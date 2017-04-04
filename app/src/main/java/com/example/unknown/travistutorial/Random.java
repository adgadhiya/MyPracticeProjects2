package com.example.unknown.travistutorial;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Random extends AppCompatActivity {

    EditText Type;
    TextView textView;
    Button command;
    ToggleButton toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        Type = (EditText)findViewById(R.id.type);
        textView = (TextView)findViewById(R.id.textView2);
        command = (Button)findViewById(R.id.command);
        toggle = (ToggleButton)findViewById(R.id.toggle);


        command.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String condition = Type.getText().toString();

                switch (condition){
                    case "BLUE":{
                        textView.setTextColor(Color.BLUE);
                        break;
                    }
                    case "LEFT":{
                        textView.setGravity(Gravity.LEFT);
                        break;
                    }
                    case "RIGHT":{
                        textView.setGravity(Gravity.RIGHT);
                        break;
                    }
                    case "DOWN":{
                        textView.setGravity(Gravity.NO_GRAVITY);
                        break;
                    }
                    case "HI":{
                        java.util.Random random = new java.util.Random();
                        textView.setTextSize(random.nextInt(80));
                        textView.setTextColor(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
                        textView.setText(condition);
                        switch (random.nextInt(3)){
                            case 0: {textView.setGravity(Gravity.RIGHT);break;}
                            case 2: {textView.setGravity(Gravity.CENTER);break;}
                            case 1: {textView.setGravity(Gravity.LEFT);break;}
                        }
                        break;
                    }
                }

            }
        });

        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggle.isChecked()){
                    Type.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                }
                else{
                    Type.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }
        });
    }
}
