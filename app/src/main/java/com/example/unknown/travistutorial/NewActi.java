package com.example.unknown.travistutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class NewActi extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,View.OnClickListener {

    TextView Rtext;
    RadioGroup radio;
    Button Return;

    String Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Rtext = (TextView)findViewById(R.id.Rtext);
        radio = (RadioGroup)findViewById(R.id.radio);
        Return= (Button)findViewById(R.id.Return);

        radio.setOnCheckedChangeListener(NewActi.this);
        Return.setOnClickListener(NewActi.this);
        SharedPreferences myPref = PreferenceManager.getDefaultSharedPreferences(this);
        String prefString = myPref.getString("name","You are...");
        Rtext.setText(prefString);

//        Bundle getValue = getIntent().getExtras();
//        Value = getValue.getString("key");
//        Rtext.setText(Value);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.radioButton:
                    Value = "YEaaaaaaa";
                    break;
                case R.id.radioButton2:
                    Value = "Bingoooooooo";
                    break;
                case R.id.radioButton3:
                    Value = "COOOOOOOOOlll";
                    break;
            }
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("Return",Value);
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }
}
