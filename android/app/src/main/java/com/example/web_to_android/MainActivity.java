package com.example.web_to_android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

/**
 * @author Nikola Lukic
 * Simple
 */
/**
 * @author Nikola Lukic
 * Simple
 */
public class MainActivity extends AppCompatActivity {

    Button btnBack;
    Button btnGotoGoogle;
    Button btnLoadLocal;
    WebView web1;

    public class MyWebChromeClient extends WebChromeClient {
        //Handle javascript alerts:
        @SuppressLint("WrongConstant")
        @Override
        public boolean onJsAlert(WebView view, String url, String message, final android.webkit.JsResult result) {
            Log.d("alert", message);
            Toast.makeText(getBaseContext(), message, 0xbb8).show();
            result.confirm();
            return true;
        };
    }

    // Add this inner class to handle URL loading
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url); // Load all URLs within the WebView
            return true; // Indicate that you have handled the URL
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web1 = (WebView)findViewById(R.id.webBrowserMain);
        web1.setWebChromeClient(new MyWebChromeClient());

        // This is the key line you were missing!
        web1.setWebViewClient(new MyWebViewClient());

        WebSettings webSettings = web1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Important for modern web pages
        webSettings.setDomStorageEnabled(true);

        btnGotoGoogle = (Button)findViewById(R.id.buttonGotoGoogle);
        btnBack = (Button)findViewById(R.id.buttonGoBack);
        btnLoadLocal = (Button)findViewById(R.id.button_LoadLocal);

        btnGotoGoogle.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        TextView TitleText = (TextView)findViewById(R.id.buttonGotoGoogle);
                        TitleText.setText("maximumroulette.com production");
                        // Fix: Use the actual string resource
                        web1.loadUrl(getString(R.string.applicationAddress));

                    }
                }
        );

        btnLoadLocal.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView TitleText = (TextView)findViewById(R.id.button_LoadLocal);
                        TitleText.setText("Loaded");
                        web1.loadUrl("https://maximumroulette.com/apps/webgpu");
                    }
                }
        );

        btnBack.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView TitleText = (TextView)findViewById(R.id.buttonGoBack);

                        // Clears only the RAM cache, leaving disk files intact
                        // web1.clearCache(false);

                        // Clears both the RAM cache and disk files
                        web1.clearCache(true);
                        web1.reload();
                            TitleText.setText("REFRESH");

                    }
                }
        );

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        btnGotoGoogle.performClick();
                        Log.i("tag", "Porter is running");
                    }
                }, 1300);
    }
}