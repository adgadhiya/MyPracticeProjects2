package com.example.unknown.travistutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SlidingDrawer;

public class sliding extends AppCompatActivity {

    private SlidingDrawer slidingDrawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding);

        slidingDrawer = (SlidingDrawer)findViewById(R.id.slidingDrawer);
    }
}
