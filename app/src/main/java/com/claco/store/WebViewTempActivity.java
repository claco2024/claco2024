package com.claco.store;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewTempActivity extends AppCompatActivity {

      private WebView webView;
      private AlertDialog noInternetDialog;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_web_view_temp);

            webView = findViewById(R.id.webview);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setBuiltInZoomControls(false);
            webView.getSettings().setDisplayZoomControls(false);
            webView.getSettings().setSupportZoom(false);

            loadWebView();
      }

      private void loadWebView() {
            if (NetworkUtil.isInternetAvailable(this)) {
                  webView.setWebViewClient(new CustomWebViewClient());
                  webView.loadUrl("https://www.claco.in/");
            } else {
                  showNoInternetDialog();
            }
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

      private void showNoInternetDialog() {
            if (noInternetDialog != null && noInternetDialog.isShowing()) {
                  return;
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View dialogView = inflater.inflate(R.layout.no_internet_dilog, null);
            builder.setView(dialogView);

            noInternetDialog = builder.create();

            TextView dialogTitle = dialogView.findViewById(R.id.dialog_title);
            TextView dialogMessage = dialogView.findViewById(R.id.dialog_message);
            Button dialogButton = dialogView.findViewById(R.id.dialog_button);

            dialogTitle.setText("No Internet Connection");
            dialogMessage.setText("Please check your internet settings and try again.");

            dialogButton.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                        noInternetDialog.dismiss();
                        // Re-check the internet connection and reload the WebView
                        loadWebView();
                  }
            });

            noInternetDialog.show();
      }

      private class CustomWebViewClient extends WebViewClient {
            @RequiresApi(api = 23)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                  super.onReceivedError(view, request, error);
                  if (!NetworkUtil.isInternetAvailable(WebViewTempActivity.this)) {
                        showNoInternetDialog();
                  }
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                  super.onReceivedError(view, errorCode, description, failingUrl);
                  if (!NetworkUtil.isInternetAvailable(WebViewTempActivity.this)) {
                        showNoInternetDialog();
                  }
            }
      }
}
