package com.example.unknown.travistutorial;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Lati_Longi extends AppCompatActivity {

    EditText lati,longi;
    Button gMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lati__longi);

        lati = (EditText)findViewById(R.id.lati);
        longi= (EditText)findViewById(R.id.longi);
        gMap = (Button)findViewById(R.id.gMap);

        gMap.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String Lati = lati.getText().toString();
                        String Longi=longi.getText().toString();

                        Uri uri = Uri.parse("geo:"+Lati+","+Longi);

                        startActivity(new Intent(Intent.ACTION_VIEW,uri));
                    }
                }
        );
    }
}
