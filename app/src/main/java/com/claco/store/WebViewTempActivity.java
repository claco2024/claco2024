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
            webView.setWebViewClient(new WebViewClient() {
                  @Override
                  public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);
                        // Dismiss any existing toast messages if necessary
                        webView.evaluateJavascript("window.getSelection().removeAllRanges();", null);
                  }
            });
            webView.loadUrl("https://www.claco.in/");
      }

      @Override
      public void onBackPressed() {
            // Check if the WebView can go back
            if (webView.canGoBack()) {
                  webView.goBack(); // If so, go back
            } else {
                  super.onBackPressed(); // If not, proceed with the normal back button behavior
            }
      }

      @Override
      public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            // This overrides the default context menu creation
            // So that the "Copy" toast message won't be shown
      }
}
