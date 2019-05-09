package com.example.ifbrowser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var etUrl : EditText
    private lateinit var btGo : Button
    private lateinit var wbPagina : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.etUrl = findViewById(R.id.etUrl)
        this.btGo = findViewById(R.id.btGo)
        this.wbPagina = findViewById(R.id.wbPagina)

        wbPagina.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }

        wbPagina.getSettings().setJavaScriptEnabled(true)
        wbPagina.getSettings().setSupportZoom(true)
        etUrl.setText("https://www.ifpb.edu.br")
        wbPagina.loadUrl(etUrl.text.toString())

        btGo.setOnClickListener({carregar(it)})

    }//closes onCreate()

    private fun carregar(view: View?) {
        wbPagina.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        this.wbPagina.loadUrl(this.etUrl.text.toString())
    }
}
