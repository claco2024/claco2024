package com.claco.store;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewTempActivity extends AppCompatActivity {

      private WebView webView;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_web_view_temp);

            webView = findViewById(R.id.webview);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setBuiltInZoomControls(false); // Disable built-in zoom controls
            webView.getSettings().setDisplayZoomControls(false); // Disable zoom display controls
            webView.getSettings().setSupportZoom(false); // Disable zoom support

            webView.setWebViewClient(new WebViewClient() {
                  @Override
                  public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);
                        webView.evaluateJavascript("window.getSelection().removeAllRanges();", null);
                  }
            });
            webView.loadUrl("https://www.claco.in/");
      }

      @Override
      public void onBackPressed() {
            if (webView.canGoBack()) {
                  webView.goBack();
            } else {
                  super.onBackPressed();
            }
      }

      @Override
      public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            // This overrides the default context menu creation
      }
}
