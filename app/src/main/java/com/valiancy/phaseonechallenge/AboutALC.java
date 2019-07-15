package com.valiancy.phaseonechallenge;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WebView aboutWebView = findViewById(R.id.webView);
        String url = "https://andela.com/alc/";
        aboutWebView.loadUrl(url);

        WebSettings settings = aboutWebView.getSettings();
        settings.setJavaScriptEnabled(true);

        aboutWebView.setWebViewClient(new MyWebViewClient());
    }

    /**
     * Ran into issues getting webview to work and fixed it by applying the solutions
     * proposed below:
     * https://stackoverflow.com/questions/47524032/webview-shows-error-didnt-find-class-android-webkit-renderprocessgonedetail
     * https://stackoverflow.com/questions/57027277/error-while-trying-to-load-a-url-in-webview-android
     */
    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @SuppressWarnings("deprecation")
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return true;
        }

        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }


        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // When an error occurs, ignore and go on
        }
    }

}
