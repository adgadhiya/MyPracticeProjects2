package com.example.unknown.travistutorial;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ImageSliderlass extends AppCompatActivity {

    ViewPager viewPager;
    CustomSwipeAdapter customSwipeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_sliderlass);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        customSwipeAdapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(customSwipeAdapter);

    }
}
