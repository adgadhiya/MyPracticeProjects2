package com.example.unknown.travistutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Acti2Acti extends AppCompatActivity implements View.OnClickListener {

    EditText edtransfer;
    Button bSA;
    Button bSAFR;
    TextView myText;

    String RString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acti2);

        edtransfer = (EditText)findViewById(R.id.edtransfer);
        bSA = (Button)findViewById(R.id.bSA);
        bSAFR = (Button)findViewById(R.id.bSAFR);
        myText= (TextView)findViewById(R.id.myText);

        bSA.setOnClickListener(Acti2Acti.this);
        bSAFR.setOnClickListener(Acti2Acti.this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bSA:{
                String StoTRans = edtransfer.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("key",StoTRans);
                Intent i = new Intent(Acti2Acti.this,NewActi.class);
                i.putExtras(bundle);
                startActivity(i);
            }
            case R.id.bSAFR:{
                Intent i = new Intent(Acti2Acti.this,NewActi.class);
                startActivityForResult(i,0);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            RString = bundle.getString("Return");
            myText.setText(RString);
        }
    }
}
