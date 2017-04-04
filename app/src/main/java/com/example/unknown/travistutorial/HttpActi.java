package com.example.unknown.travistutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HttpActi extends AppCompatActivity {

    TextView tvHttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        tvHttp = (TextView)findViewById(R.id.tvHttp);
    }
}
