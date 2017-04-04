package com.example.unknown.travistutorial;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by UNKNOWN on 6/25/2016.
 */
public class BinderClass extends Service {

    private IBinder iBinder = new LocalClass();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public class LocalClass extends Binder{

        public BinderClass getService(){
            return BinderClass.this;
        }

    }

    public String firstMessage(){
        return "This is First Message";
    }


    public String secondMessage(){
        return "This is Second Message";
    }
}
