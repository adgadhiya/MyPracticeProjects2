package com.example.unknown.travistutorial;

import android.hardware.input.InputManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

public class TabWidgetHost extends AppCompatActivity implements View.OnClickListener {

    TabHost tabHost;
    Button load,reload,back,frwrd;
    WebView browser;
    EditText URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_widget_host);
        load = (Button)findViewById(R.id.Load);
        reload = (Button)findViewById(R.id.Reload);
        back = (Button)findViewById(R.id.Back);
        frwrd = (Button)findViewById(R.id.Forward);

        URL = (EditText)findViewById(R.id.etWeb);

        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.showSoftInputFromInputMethod(URL.getWindowToken(),0);

        browser=(WebView) findViewById(R.id.webview);
        browser.setWebViewClient(new OurClient());
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setSupportMultipleWindows(true);
        browser.getSettings().setLoadWithOverviewMode(true);
        browser.getSettings().setLoadWithOverviewMode(true);

        load.setOnClickListener(TabWidgetHost.this);
        reload.setOnClickListener(TabWidgetHost.this);
        back.setOnClickListener(TabWidgetHost.this);
        frwrd.setOnClickListener(TabWidgetHost.this);

        tabHost =(TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("Tag1");
        spec.setContent(R.id.linearLayout3);
        spec.setIndicator("Digital");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Tag2");
        spec.setContent(R.id.linearLayout5);
        spec.setIndicator("TextView");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Tag3");
        spec.setContent(R.id.linearLayout4);
        spec.setIndicator("Analog");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Tag2");
        spec.setContent(R.id.linearLayout5);
        spec.setIndicator("TextView");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Tag3");
        spec.setContent(R.id.linearLayout4);
        spec.setIndicator("Analog");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Tag2");
        spec.setContent(R.id.linearLayout5);
        spec.setIndicator("TextView");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Tag3");
        spec.setContent(R.id.linearLayout4);
        spec.setIndicator("Analog");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Tag2");
        spec.setContent(R.id.linearLayout5);
        spec.setIndicator("TextView");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Tag3");
        spec.setContent(R.id.linearLayout4);
        spec.setIndicator("Analog");
        tabHost.addTab(spec);
    }

    @Override
    public void onClick(View v) {
        String url = URL.getText().toString();
        switch (v.getId()){
            case R.id.Forward:
                if(browser.canGoForward())
                    browser.goForward();
                break;
            case R.id.Back:
                if(browser.canGoBack())
                    browser.goBack();
                break;
            case R.id.Load:
                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(URL.getWindowToken(),0);
                browser.loadUrl(url);
                break;
            case R.id.Reload:
                browser.reload();
                break;
        }
    }
}
