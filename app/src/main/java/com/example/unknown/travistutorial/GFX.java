package com.example.unknown.travistutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GFX extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphics(this));
    }
}
