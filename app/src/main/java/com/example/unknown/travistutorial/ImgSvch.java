package com.example.unknown.travistutorial;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class ImgSvch extends Activity implements AdapterView.OnItemSelectedListener,ViewSwitcher.ViewFactory{
    ImageSwitcher imageSwitcher;
    Gallery gallery;

    int[] images = {R.mipmap.first,R.mipmap.first2,R.mipmap.first3,R.mipmap.first4,R.mipmap.first5,R.mipmap.first6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_svch);
        imageSwitcher = (ImageSwitcher)findViewById(R.id.imageSwitcher);
        gallery = (Gallery)findViewById(R.id.gallery2);
        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));

        gallery.setAdapter(new ImagGal(this));
        gallery.setOnItemSelectedListener(ImgSvch.this);
    }

    public class ImagGal extends BaseAdapter{
        Context c;
        public ImagGal(Context imgSvch) {
            c = imgSvch;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView img = new ImageView(c);
            img.setScaleType(ImageView.ScaleType.CENTER);
            img.setLayoutParams(new Gallery.LayoutParams(150,210));
            img.setBackgroundColor(Color.BLUE);
            img.setAdjustViewBounds(true);
            img.setImageResource(images[position]);
            return  img;

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        imageSwitcher.setImageResource(images[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public View makeView() {
        ImageView switchIMG = new ImageView(this);
        switchIMG.setBackgroundColor(0xdcdcdc);
        switchIMG.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                                                                ViewGroup.LayoutParams.FILL_PARENT));
        switchIMG.setScaleType(ImageView.ScaleType.FIT_XY);
        return switchIMG;
    }
}
