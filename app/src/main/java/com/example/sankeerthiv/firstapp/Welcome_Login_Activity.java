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

    public static final String AUTH_URL="https://herocard.vmwareidentity.com/SAAS/auth/";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__login_);

        relativeLogin1= (RelativeLayout)findViewById(R.id.relativeLogin1);
        handler.postDelayed(runnable, 3000);



        webView = (WebView) findViewById(R.id.webview);
        webView.bringToFront();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        webView.setWebViewClient(new LoginWebView() );
        webView.loadUrl("https://herocard.vmwareidentity.com/SAAS/auth/login?dest=https://herocard.vmwareidentity.com/SAAS/auth/oauth2/authorize?response_type%3Dcode%26client_id%3Dappbuilder-mobileapps-dev%26redirect_uri%3Dhttp://localhost:8080&chainedauthMethods=%5B%7B%22chainedAuthmethods%22:%5B%7B%22authMethoId%22:913533,%22authMethodOrder%22:0%7D%5D%7D,%7B%22chainedAuthmethods%22:%5B%7B%22authMethoId%22:845496,%22authMethodOrder%22:0%7D%5D%7D%5D&ttl=28800");

    }

    private class LoginWebView extends WebViewClient{

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
            if(isFinishing() || Welcome_Login_Activity.this.isDestroyed()){
                return;
            }
            UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer(url);
            Toast.makeText(Welcome_Login_Activity.this, url+ " URL", Toast.LENGTH_SHORT).show();
            Log.v("URL",url);

            String code = urlQuerySanitizer.getValue("code");
            Toast.makeText(Welcome_Login_Activity.this, code, Toast.LENGTH_SHORT).show();

//            Log.v("URL",code);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            Toast.makeText(Welcome_Login_Activity.this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }


    public void callAuthUrl(String code ){

    }
}
