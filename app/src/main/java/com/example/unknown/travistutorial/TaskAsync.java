package com.example.unknown.travistutorial;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskAsync extends AppCompatActivity implements View.OnClickListener {

    EditText etAsync;
    TextView tvAsync;

    String MYFILE = "MyFile";

    FileInputStream fis;
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_async);

        etAsync = (EditText)findViewById(R.id.etAsync);
        tvAsync = (TextView) findViewById(R.id.tvAsync);

        Button load = (Button)findViewById(R.id.loadAsync);
        Button save = (Button)findViewById(R.id.saveAsync);

        load.setOnClickListener(this);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String string = etAsync.getText().toString();
        switch (v.getId()){
            case R.id.saveAsync:
                try {
                    fos = openFileOutput(MYFILE,MODE_PRIVATE);
                    fos.write(string.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.loadAsync:
                new LoadStuff().execute(MYFILE);
                break;
        }
    }

    public class LoadStuff extends AsyncTask<String,Integer,String>{
        StringBuffer sb = new StringBuffer();
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(TaskAsync.this);
            progressDialog.setMax(100);
            progressDialog.setTitle("Progress Indicator");
            progressDialog.setProgressStyle(ProgressDialog.BUTTON_NEUTRAL);
            progressDialog.show();
            progressDialog.setCancelable(false);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
           tvAsync.setText(s);
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
                progressDialog.incrementProgressBy(values[0]);
        }

        @Override
        protected String doInBackground(String... params) {

            for(int i=0;i<20;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(5);
            }
            progressDialog.dismiss();

            try {
                fis = openFileInput(MYFILE);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                String line;
                while((line = br.readLine())!=null){
                    sb.append(line + "\n");
                }
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                return sb.toString();
            }
        }
    }
}
