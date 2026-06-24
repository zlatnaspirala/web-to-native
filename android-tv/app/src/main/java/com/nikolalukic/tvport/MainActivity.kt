package com.nikolalukic.tvport

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.webkit.PermissionRequest
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {



    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        android.webkit.WebView.setDataDirectorySuffix("main")
        WebView.setWebContentsDebuggingEnabled(true)

        webView = WebView(this)
        setContentView(webView)

        webView.setWebViewClient(WebViewClient())
        webView.setWebChromeClient(object : WebChromeClient() {
            override fun onPermissionRequest(request: PermissionRequest) {
                request.grant(request.resources) // camera + mic
            }
        })



        val s: WebSettings = webView.settings
        s.javaScriptEnabled = true
        s.domStorageEnabled = true
        s.mediaPlaybackRequiresUserGesture = false
        // add:
        s.setRenderPriority(WebSettings.RenderPriority.HIGH)
//      webView.loadUrl("https://maximumroulette.com/apps/webgpu/examples.html")
        webView.loadUrl("chrome://flags")

        webView.evaluateJavascript("navigator.gpu ? 'GPU EXISTS' : 'NO GPU'") { result ->
            Log.d("WEBGPU", result)
        }

    }

    override fun onBackPressed() {
        if (webView.canGoBack()) webView.goBack()
        else super.onBackPressed()
    }
}