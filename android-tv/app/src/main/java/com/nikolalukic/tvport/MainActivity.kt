package com.nikolalukic.tvport

import android.annotation.SuppressLint
import android.net.http.SslError
import android.os.Bundle
import android.util.Log
import android.webkit.PermissionRequest
import android.webkit.SslErrorHandler
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
                request.grant(request.resources)
            }
        })
        val s: WebSettings = webView.settings
        s.javaScriptEnabled = true
        s.domStorageEnabled = true
        s.mediaPlaybackRequiresUserGesture = false
        s.allowFileAccessFromFileURLs = true
        // s.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        // webView.loadUrl("https://maximumroulette.com/apps/webgpu/examples.html")
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                view.evaluateJavascript("navigator.gpu ? 'GPU EXISTS' : 'NO GPU'") { result ->
                    Log.d("WEBGPU", result)
                }
            }
            override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
                handler.proceed() // dev
            }
        }

        webView.loadUrl("https://192.168.0.33/PRIVATE_SERVER/me/meGPU/matrix-engine-wgpu/public/tv-10.html")
//        webView.loadUrl("https://maximumroulette.com/apps/webgpu/tv-10.html")
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) webView.goBack()
        else super.onBackPressed()
    }
}