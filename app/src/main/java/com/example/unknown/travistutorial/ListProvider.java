package com.example.unknown.travistutorial;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by UNKNOWN on 6/26/2016.
 */
public class ListProvider{

    int icon;
    String mName,mRating;

    public ListProvider(int icon,String mName,String mRating){
        this.setIcon(icon);
        this.setmName(mName);
        this.setmRating(mRating);
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmRating() {
        return mRating;
    }

    public void setmRating(String mRating) {
        this.mRating = mRating;
    }
}
