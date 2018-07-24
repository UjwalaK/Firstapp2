package com.example.sankeerthiv.firstapp;

import android.graphics.Bitmap;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class Welcome_Login_Activity extends AppCompatActivity {
    private WebView webView;
    RelativeLayout relativeLogin1;


    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            relativeLogin1.setVisibility(View.VISIBLE);


        }
    };








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__login_);

        relativeLogin1= (RelativeLayout)findViewById(R.id.relativeLogin1);
        handler.postDelayed(runnable, 3000);



        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://login.vmware.com");

    }

    /*private class LoginWebView extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Toast.makeText(Welcome_Login_Activity.this, "Login Success", Toast.LENGTH_SHORT).show();
            Log.v("URL",url);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            Toast.makeText(Welcome_Login_Activity.this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }*/
}
