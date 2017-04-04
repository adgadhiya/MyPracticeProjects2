package com.example.unknown.travistutorial;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.InputStream;

import static java.lang.Thread.sleep;

public class MainActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          Thread myThread = new Thread(){
              public void run() {
                  try {
                      sleep(500);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }finally {
                      Intent intent = new Intent("com.example.unknown.travistutorial.AllClasses");
                      startActivity(intent);
                  }
              }
          };
          myThread.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
       finish();
    }
}
