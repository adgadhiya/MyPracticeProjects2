package com.example.unknown.travistutorial;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by UNKNOWN on 6/25/2016.
 */
public class IpcClass extends Service {

    Messenger messenger = new Messenger(new LocalClass());

    static final int JOB_1 = 1;
    static final int JOB_1_RESPONSE = 2;
    static final int JOB_2 = 3;
    static final int JOB_2_RESPONSE = 4;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    public class LocalClass extends Handler {

        @Override
        public void handleMessage(Message msg) {

            Message MSG;
            String message;
            Bundle bundle = new Bundle();

            switch (msg.what){

                case JOB_1:
                    MSG = Message.obtain(null,JOB_1_RESPONSE);
                    message = "This is first message from service";
                    bundle.putString("SERVICE_MESSAGE",message);
                    MSG.setData(bundle);
                    try {
                        msg.replyTo.send(MSG);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }

                    break;

                case JOB_2:
                    MSG = Message.obtain(null,JOB_2_RESPONSE);
                    message = "This is Second message from service";
                    bundle.putString("SERVICE_MESSAGE",message);
                    MSG.setData(bundle);
                    try {
                        msg.replyTo.send(MSG);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    }
}
