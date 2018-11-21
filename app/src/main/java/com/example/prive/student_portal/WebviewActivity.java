package com.example.prive.student_portal;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Objects;

public class WebviewActivity extends AppCompatActivity {

    WebView webView;

    StoreInfo storeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = findViewById(R.id.webView);
        storeInfo = Objects.requireNonNull(getIntent().getExtras()).getParcelable(MainActivity.PORTAL);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(storeInfo.getUrl());
    }
}
