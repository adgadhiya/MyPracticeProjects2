package com.example.unknown.travistutorial;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfigRotation extends AppCompatActivity implements View.OnClickListener {

    Uri Contacts = null;
    Button Cpick,Cview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_rotation);

        Cpick = (Button)findViewById(R.id.Cpick);
        Cview = (Button)findViewById(R.id.Cview);

        Cpick.setOnClickListener(this);
        Cview.setOnClickListener(this);

        restoreme();

        Cview.setEnabled(Contacts!=null);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return Contacts;
    }

    public void restoreme(){
        Contacts = null;
        if(getLastCustomNonConfigurationInstance()!=null){
            Contacts = (Uri)getLastCustomNonConfigurationInstance();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Contacts = data.getData();
            Cview.setEnabled(true);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.Cpick:
                Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(i,0);
                break;
            case R.id.Cview:
                startActivity(new Intent(Intent.ACTION_VIEW,Contacts));
        }
            }
}