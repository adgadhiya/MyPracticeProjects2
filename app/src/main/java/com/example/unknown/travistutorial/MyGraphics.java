package com.example.unknown.travistutorial;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

/**
 * Created by UNKNOWN on 6/2/2016.
 */
public class MyGraphics extends View {

    Bitmap bmp;
    public MyGraphics(Context gfx) {
        super(gfx);
        bmp = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect();
        rect.set(0,400,canvas.getWidth(),500);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);


        canvas.drawBitmap(bmp,(canvas.getWidth()/2),(canvas.getHeight()/2),null);
        canvas.drawARGB(0,256,256,0);
        canvas.drawRect(rect,paint);
    }
}
