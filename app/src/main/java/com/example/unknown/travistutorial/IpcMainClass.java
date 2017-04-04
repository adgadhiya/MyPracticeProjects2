package com.example.unknown.travistutorial;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IpcMainClass extends AppCompatActivity implements View.OnClickListener {

    static final int JOB_1 = 1;
    static final int JOB_1_RESPONSE = 2;
    static final int JOB_2 = 3;
    static final int JOB_2_RESPONSE = 4;

    boolean isBind = false;

    Button btn7,btn8;
    TextView tv4;
    Messenger messenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc_main_class);

        Intent intent = new Intent(this,IpcClass.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

        btn7 = (Button)findViewById(R.id.button7);
        btn8 = (Button)findViewById(R.id.button8);

        tv4 = (TextView) findViewById(R.id.textView4);

        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Message message;

        switch (v.getId()){

            case R.id.button7:
                message = Message.obtain(null,JOB_1);
                message.replyTo = new Messenger(new HandleMSG());
                try {
                    messenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button8:
                message = Message.obtain(null,JOB_2);
                message.replyTo = new Messenger(new HandleMSG());
                try {
                    messenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;


        }

    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messenger = new Messenger(service);
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            messenger = null;
            isBind = false;
        }
    };

    @Override
    protected void onStop() {
        if(isBind){
            unbindService(serviceConnection);
            messenger = null;
            isBind = false;
        }

        super.onStop();
    }

    public class HandleMSG extends Handler {
        @Override
        public void handleMessage(Message msg) {
            String message;
            switch (msg.what){
                case JOB_1_RESPONSE:

                    message = msg.getData().getString("SERVICE_MESSAGE");
                    tv4.setText(message);

                    break;
                case JOB_2_RESPONSE:
                    message = msg.getData().getString("SERVICE_MESSAGE");
                    tv4.setText(message);
                    break;

            }

            super.handleMessage(msg);
        }
    }



}
