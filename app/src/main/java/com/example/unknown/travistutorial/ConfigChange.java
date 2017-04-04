package com.example.unknown.travistutorial;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfigChange extends AppCompatActivity {

    Uri Contacs;
    Button CCpick,CCview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setup();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setup();
    }

    public  void setup(){
        setContentView(R.layout.activity_config_change);

       CCpick = (Button)findViewById(R.id.CCpick);
       CCview = (Button)findViewById(R.id.CCview);

        CCview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Intent.ACTION_VIEW,Contacs));
                    }
                }
        );
        CCpick.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                        startActivityForResult(i,0);
                    }
                }
        );

        CCview.setEnabled(Contacs!=null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Contacs = data.getData();
            CCview.setEnabled(true);
        }
    }
}
