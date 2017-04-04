package com.example.unknown.travistutorial;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MyGal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_gal);
        Gallery gallery = (Gallery)findViewById(R.id.gallery);
        gallery.setAdapter(new MyImage(this));
    }
    
    public class MyImage extends BaseAdapter{
        Context c;
        int[] images = {R.mipmap.first,R.mipmap.first2,R.mipmap.first3,R.mipmap.first4,R.mipmap.first5,
                R.mipmap.first6,R.mipmap.first7,R.mipmap.first8,R.mipmap.first9,R.mipmap.first10};
        int MyImg;
        public MyImage(Context myGal) {
            c = myGal;
            TypedArray a = c.obtainStyledAttributes(R.styleable.MyGallery);
            MyImg = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground,0);
            a.recycle();
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
            img.setImageResource(images[position]);
            img.setBackgroundResource(MyImg);
            img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            img.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return img;
        }
    }
}
