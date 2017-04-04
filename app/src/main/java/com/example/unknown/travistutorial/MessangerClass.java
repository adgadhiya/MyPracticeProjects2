package com.example.unknown.travistutorial;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.support.design.widget.SwipeDismissBehavior;
import android.widget.Toast;

/**
 * Created by UNKNOWN on 6/25/2016.
 */
public class MessangerClass extends Service {

    Messenger messenger = new Messenger(new LocalClass());

    static final int JOB_1 = 1;
    static final int JOB_2 = 2;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    public class LocalClass extends Handler{

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case JOB_1:
                    Toast.makeText(getApplicationContext(),"First MSG",Toast.LENGTH_SHORT).show();
                    break;
                case JOB_2:
                    Toast.makeText(getApplicationContext(),"Second MSG",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }
}
