package com.example.unknown.travistutorial;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SharedPrefs extends AppCompatActivity implements View.OnClickListener {

    EditText et;
    Button load,save;
    TextView tv;

    static String spS = "MyString";
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefs);

        et = (EditText)findViewById(R.id.etPrefs);
        load = (Button)findViewById(R.id.viewData);
        save = (Button)findViewById(R.id.save);
        tv = (TextView)findViewById(R.id.sharedData);

        sp = getSharedPreferences(spS,0);

        save.setOnClickListener(this);
        load.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.save:
                String string = et.getText().toString();
                SharedPreferences.Editor editor =  sp.edit();
                editor.putString("Data",string);
                editor.commit();
                break;
            case R.id.viewData:
                sp = getSharedPreferences(spS,0);
                String str = sp.getString("Data","No any Saved Data");
                tv.setText(str);
                break;
        }
    }
}
