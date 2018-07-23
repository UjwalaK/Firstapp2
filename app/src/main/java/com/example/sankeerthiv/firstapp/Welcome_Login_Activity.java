package com.example.sankeerthiv.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Welcome_Login_Activity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__login_);
        webView = (WebView) findViewById(R.id.webview);
        System.out.print("yo");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://login.vmware.com");

    }
}
