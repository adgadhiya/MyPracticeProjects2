package com.example.unknown.travistutorial;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MyFlip extends Activity {

    ViewFlipper viewFlipper;

    static final int[] images = {R.mipmap.first4,R.mipmap.first3,R.mipmap.first,R.mipmap.first2,R.mipmap.first6,
                                R.mipmap.first5,R.mipmap.first4,R.mipmap.first3,R.mipmap.first2,R.mipmap.first5,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_flip);
        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
        viewFlipper.setForegroundGravity(Gravity.AXIS_PULL_AFTER);

        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));

        for (int image : images){
            ImageView iv = new ImageView(this);
            iv.setImageResource(image);
            iv.setLayoutParams(new ViewGroup.LayoutParams(300,700));
            iv.setScaleType(ImageView.ScaleType.CENTER);
            viewFlipper.addView(iv,new ViewGroup.LayoutParams(300,700));
                    }
        viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();
    }
}
