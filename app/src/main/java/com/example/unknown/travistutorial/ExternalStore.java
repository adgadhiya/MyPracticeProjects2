package com.example.unknown.travistutorial;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static android.os.Environment.MEDIA_MOUNTED;

public class ExternalStore extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    TextView canR,canW;
    String status;
    boolean CANREAD,CANWRITE;
    Spinner spinner;
    EditText etSaveAs;
    Button confirm,saveFILE;

    String[] paths = {"Music","Pictures","Downloads"};
    File path = null;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_store);

        canR = (TextView)findViewById(R.id.canR);
        canW = (TextView)findViewById(R.id.canW);
        spinner= (Spinner)findViewById(R.id.spinner);
        etSaveAs=(EditText)findViewById(R.id.etSaveAs);
        confirm=(Button)findViewById(R.id.confirm);
        saveFILE = (Button)findViewById(R.id.saveFile);
        saveFILE.setEnabled(false);

        confirm.setOnClickListener(this);
        saveFILE.setOnClickListener(this);
        status = Environment.getExternalStorageState();

       state();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,paths);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void state() {
        if(status.equals(Environment.MEDIA_MOUNTED)){
            canR.setText("true");
            canW.setText("true");
            CANREAD = CANWRITE =true;
        }else if(status.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            canR.setText("true");
            canW.setText("false");
            CANREAD = true;
            CANWRITE = false;

        }else{

            CANREAD = CANWRITE =false;
            canR.setText("false");
            canW.setText("false");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                break;
            case 1:
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                break;
            case 2:
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {

        path.mkdirs();

        switch (v.getId()){
            case R.id.confirm:
                saveFILE.setEnabled(true);
                break;
            case R.id.saveFile:
                saveFILE.setEnabled(false);
                String p = etSaveAs.getText().toString();
                file = new File(path,p+".mp3");

                state();
                if(CANWRITE == CANREAD == true){
                    try {
                        FileOutputStream fos = new FileOutputStream(file);
                        InputStream is = getResources().openRawResource(R.raw.japan_flute_birds);
                        byte[] bite = new byte[is.available()];
                        is.read(bite);
                        fos.write(bite);
                        fos.close();
                        is.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                MediaScannerConnection.scanFile(ExternalStore.this, new String[]{file.toString()}, null,
                        new MediaScannerConnection.OnScanCompletedListener() {
                            @Override
                            public void onScanCompleted(String path, Uri uri) {
                                Toast.makeText(ExternalStore.this,"Scan Complete",Toast.LENGTH_LONG);
                            }
                        });
                break;
        }
    }
}
