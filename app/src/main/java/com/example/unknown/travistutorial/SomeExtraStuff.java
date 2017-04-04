package com.example.unknown.travistutorial;

import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class SomeExtraStuff extends Activity implements GestureOverlayView.OnGesturePerformedListener {

    private GestureLibrary library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GestureOverlayView gestureOverlayView = new GestureOverlayView(getApplicationContext());
        View view = getLayoutInflater().inflate(R.layout.activity_some_extra_stuff,null);
        gestureOverlayView.addView(view);
        gestureOverlayView.addOnGesturePerformedListener(this);
        setContentView(gestureOverlayView);
    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        ArrayList<Prediction> predictions = library.recognize(gesture);
        for(Prediction prediction : predictions){
            Toast.makeText(this,prediction.name.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
