package com.tatlicilar.downtoup;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewSample extends AppCompatActivity {

    private WebSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view2);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("E-Kitap");
        WebView tarayici;
        tarayici= (WebView) findViewById (R.id.webview1);
        tarayici.getSettings().setJavaScriptEnabled(true);

        tarayici.loadUrl("http://www.onlinekitapoku.com/component/djcatalog2/kitap/1-roman/117-anna-karenina.html#.WcQse7JJbDc");

        tarayici.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }
        });

        alert.setView(tarayici);

    }

    private void loadUrl(String s) {
    }

    public WebSettings getSettings() {
        return settings;
    }
}
