package com.example.unknown.travistutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvFILE;
    EditText etFILE;

    FileInputStream fis;
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        Button save = (Button)findViewById(R.id.btnSAVE);
        Button load = (Button)findViewById(R.id.btnLOAD);

        tvFILE = (TextView)findViewById(R.id.tvFILE);
        etFILE = (EditText)findViewById(R.id.etFile);

        load.setOnClickListener(this);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String string = etFILE.getText().toString();

        switch(v.getId()){
            case R.id.btnSAVE:
                try {
                    fos = openFileOutput("MYFILE.txt",MODE_PRIVATE);
                    fos.write(string.getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnLOAD:
                try {
                    fis = openFileInput("MYFILE.txt");
                    InputStreamReader ism = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(ism);
                    StringBuffer sb = new StringBuffer();
                    String line;
                    while ((line = br.readLine())!=null){
                        sb.append(line);
                        sb.append("\n");
                    }
                    fis.close();
                    tvFILE.setText(sb);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
        }
    }
}
