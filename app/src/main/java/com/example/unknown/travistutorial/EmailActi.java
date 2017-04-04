package com.example.unknown.travistutorial;

import android.content.Intent;
import android.renderscript.Type;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.xml.transform.OutputKeys;

public class EmailActi extends AppCompatActivity {

    EditText name,intro,work,lastword,email;

    String Name,Intro,Work,LastWord,Email;
    String MSG;

    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        initialize();

        send.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getmsg();
                        Intent i = new Intent(android.content.Intent.ACTION_SEND);
                        i.putExtra(android.content.Intent.EXTRA_EMAIL,Email);
                        i.putExtra(Intent.EXTRA_SUBJECT,"Thanl You");
                        i.setType("plain/text");
                        i.putExtra(Intent.EXTRA_TEXT,MSG);
                        startActivity(i);
                    }
                }
        );
    }

    public void initialize(){
        name = (EditText)findViewById(R.id.name);
        intro = (EditText)findViewById(R.id.intro);
        work = (EditText)findViewById(R.id.work);
        lastword = (EditText)findViewById(R.id.lastword);
        email = (EditText)findViewById(R.id.email);
        send = (Button)findViewById(R.id.send);
    }

    public void getmsg(){
        Name = name.getText().toString();
        Intro= intro.getText().toString();
        Work = work.getText().toString();
        LastWord= lastword.getText().toString();
        Email = email.getText().toString();

        MSG = "Hi," + Name +  ". My name is " + Intro + ". It's a great experience to wirk with you in " +Work
                + ". I want to say " + LastWord;
    }
}
