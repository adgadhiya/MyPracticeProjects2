package com.example.unknown.travistutorial;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;

/**
 * Created by UNKNOWN on 6/27/2016.
 */
public class FastSearchListViewHandler extends ListView {

    private Context context;
    private static int intWidth = 20;
    private String[] sections;
    private float scaleWidth;
    private float sx;
    private int indexSize;
    private String section;
    private boolean showLetter = true;
    private Handler listHandler;

    public FastSearchListViewHandler(Context context, AttributeSet attrs, int defStyle) {
        super(context,attrs,defStyle);
        this.context = context;
    }

    public FastSearchListViewHandler(Context context, AttributeSet attrs) {
        super(context,attrs);
        this.context = context;
    }

    public FastSearchListViewHandler(Context context,String keyList) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        scaleWidth = intWidth * getSizeInPixel(context);
        sx = this.getWidth() - this.getPaddingRight() - scaleWidth;

        Paint p = new Paint();
        p.setColor(Color.WHITE);
        p.setAlpha(100);

        canvas.drawRect(sx,this.getPaddingTop(),sx + scaleWidth,this.getHeight() - this.getPaddingBottom(),p);

        indexSize = (this.getHeight() - this.getPaddingTop() - getPaddingBottom()) / sections.length;

        Paint textPaint = new Paint();
        textPaint.setColor(Color.DKGRAY);
        textPaint.setTextSize(scaleWidth / 2);

        for(int i=0 ; i<sections.length ; i++){
            canvas.drawText(sections[i].toUpperCase(),sx + textPaint.getTextSize() / 2,getPaddingTop() + indexSize * (i+1),textPaint);
        }
    }


    private static float getSizeInPixel(Context ctx){
        return ctx.getResources().getDisplayMetrics().density;
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
        if(adapter instanceof SectionIndexer) sections = (String[]) ((SectionIndexer)adapter).getSections();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        float x = ev.getX();

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN : {
                if(x < sx) return  super.onTouchEvent(ev);

                else {

                    float y = ev.getY() - this.getPaddingTop() - getPaddingBottom();
                    int currentPosition = (int)Math.floor(y / indexSize);
                    section = sections[currentPosition];
                    this.setSelection(((SectionIndexer)getAdapter()).getPositionForSection(currentPosition));
                }
                break;
            }
            case MotionEvent.ACTION_MOVE:{

                if(x < sx) return super.onTouchEvent(ev);

                else {
                    float y = ev.getY();
                    int currentPosition = (int)Math.floor(y / indexSize);
                    section = sections[currentPosition];
                    this.setSelection(((SectionIndexer)getAdapter()).getPositionForSection(currentPosition));
                }
                 break;
            }
            case MotionEvent.ACTION_UP:{
                listHandler = new ListHandler();
                listHandler.sendEmptyMessageDelayed(0,30 * 1000);
            }
        }
        return true;
    }

    private class ListHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            showLetter = false;
            FastSearchListViewHandler.this.invalidate();
        }
    }
}

