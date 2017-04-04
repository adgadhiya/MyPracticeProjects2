package com.example.unknown.travistutorial;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by UNKNOWN on 6/25/2016.
 */
public class CustomSwipeAdapter extends PagerAdapter {

    private int[] images = {R.mipmap.first,
                            R.mipmap.first6,
                            R.mipmap.first5,
                            R.mipmap.first3,
                            R.mipmap.first2};

    private Context context;
    LayoutInflater layoutInflater;

    public CustomSwipeAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object) ;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);

        ImageView imageView = (ImageView) item_view.findViewById(R.id.iv);
        TextView tv = (TextView) item_view.findViewById(R.id.image_count);

        imageView.setImageResource(images[position]);
        tv.setText("This is " + position + "image");
        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
