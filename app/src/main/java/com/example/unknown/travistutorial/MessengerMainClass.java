package com.example.unknown.travistutorial;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MessengerMainClass extends AppCompatActivity implements View.OnClickListener {

    Button btn5,btn6;
    Messenger messenger;
    boolean isBind = false;
    MessangerClass messangerClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger_main_class);

        btn5 = (Button)findViewById(R.id.button5);
        btn6 = (Button)findViewById(R.id.button6);

        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

        Intent intent = new Intent(this,MessangerClass.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

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
            isBind = false;
            messenger = null;
        }

        super.onStop();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button5:

                Message message = Message.obtain(null,MessangerClass.JOB_1);
                try {
                    messenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.button6:

                Message message1 = Message.obtain(null,MessangerClass.JOB_2);
                try {
                    messenger.send(message1);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

                break;

        }

    }
}
