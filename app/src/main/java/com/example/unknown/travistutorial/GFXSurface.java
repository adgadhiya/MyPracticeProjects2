package com.example.unknown.travistutorial;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class GFXSurface extends Activity implements View.OnTouchListener {
    SurfaceClass surfaceClass;
    float x,y, sX, sY, fX, fY, dX, dY, scaledX, scaledY, aniX, aniY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        surfaceClass = new SurfaceClass(this);
        surfaceClass.setOnTouchListener(GFXSurface.this);
        x = y =sY=sY=dX=dY=scaledY=scaledX=aniX=aniY=fX=fY=0;
        setContentView(surfaceClass);
    }

    @Override
    protected void onPause() {
        super.onPause();
        surfaceClass.pause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        surfaceClass.resume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        x = event.getX();
        y = event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                sX = event.getX();
                sY = event.getY();
                aniX = aniY = scaledY = scaledX = 0;
                fX = fY = dY = dX = 0;
                break;
            }
            case MotionEvent.ACTION_UP:{
                fX = event.getX();
                fY = event.getY();
                dX = fX - sX;
                dY = fY - sX;
                scaledX = dX/20;
                scaledY = dY/20;
                x = y =  0;
                break;
            }
        }

        return true;
    }


    class SurfaceClass extends SurfaceView implements Runnable {

        SurfaceHolder Holder;
        Bitmap andrd, img;
        Thread thread = null;
        boolean running = true;

        public SurfaceClass(Context gfxSurface) {
            super(gfxSurface);
            Holder = getHolder();
            andrd = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            img = BitmapFactory.decodeResource(getResources(), R.mipmap.myimage);

        }

        @Override
        public void run() {
            while (running) {
                if (!Holder.getSurface().isValid()) {
                    continue;
                }
                Canvas canvas = Holder.lockCanvas();
                canvas.drawColor(Color.BLUE);
                if(x != 0 && y!= 0){
                    canvas.drawBitmap(andrd,x-(andrd.getWidth()/2),y-(andrd.getHeight()/2),null);
                }
                if(sX != 0 && sY!= 0){
                    canvas.drawBitmap(andrd,sX-(andrd.getWidth()/2),sY-(andrd.getHeight()/2),null);
                }
                if(fX != 0 && fY!= 0){
                    canvas.drawBitmap(andrd,fX-(andrd.getWidth()/2)-aniX,fY-(andrd.getHeight()/2)-aniY,null);
                        canvas.drawBitmap(andrd,fX-(andrd.getWidth()/2),fY-(andrd.getHeight()/2),null);
                }
                    aniX = aniX + scaledX;
                    aniY = aniY + scaledY;

                Holder.unlockCanvasAndPost(canvas);
            }
        }
        public void pause() {
            running = false;
            while (true) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            thread = null;
        }
        public void resume() {
            running = true;
            thread = new Thread(SurfaceClass.this);
            thread.start();
        }
    }
}