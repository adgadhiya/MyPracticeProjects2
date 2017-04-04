package com.example.unknown.travistutorial;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BinderMainClass extends AppCompatActivity implements View.OnClickListener {

    Button btn3,btn4;
    TextView tv;
    BinderClass binderClass;
    boolean isBind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder_main_class);

        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        tv = (TextView)findViewById(R.id.tv);

        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        Intent intent = new Intent(this,BinderClass.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BinderClass.LocalClass localClass = (BinderClass.LocalClass) service;
            binderClass = localClass.getService();
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBind = false;

        }
    };

    @Override
    protected void onStop() {

        if(isBind){
            unbindService(serviceConnection);
            isBind =false;

        }

        super.onStop();
    }

    @Override
    public void onClick(View v) {

        String string = new String();

        switch (v.getId()){

            case R.id.button3:
                string = binderClass.firstMessage();
                tv.setText(string);
                break;
            case R.id.button4:
                string = binderClass.secondMessage();
                tv.setText(string);
                break;

        }
    }
}
