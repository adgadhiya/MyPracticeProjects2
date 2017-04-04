package com.example.unknown.travistutorial;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by UNKNOWN on 6/3/2016.
 */
public class OurClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
