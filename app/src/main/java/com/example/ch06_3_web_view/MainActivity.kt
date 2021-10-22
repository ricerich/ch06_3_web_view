package com.example.ch06_3_web_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.drawable.web)

        var edt1 = findViewById<EditText>(R.id.edtUrl)
        var btn1 = findViewById<Button>(R.id.btnGo)
        var btn2 = findViewById<Button>(R.id.btnBack)

        var webView1 = findViewById<WebView>(R.id.webView1)

        webView1.webViewClient = MyWebViewClient()

        var webSet = webView1.settings
        webSet.builtInZoomControls = true

        btn1.setOnClickListener {
            webView1.loadUrl(edt1.text.toString())
        }

        btn2.setOnClickListener {
            webView1.goBack()
        }
    }

    class MyWebViewClient : WebViewClient()
    {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            return super.shouldOverrideUrlLoading(view, url)
        }
    }
}