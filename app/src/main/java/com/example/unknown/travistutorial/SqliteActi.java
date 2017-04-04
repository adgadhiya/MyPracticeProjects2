package com.example.unknown.travistutorial;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SqliteActi extends AppCompatActivity {

    MyDataBase dataBaseHelper;
    EditText etname,etsurname,etmarks,id;
    Button addDATA,dbSHOW,update,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        dataBaseHelper = new MyDataBase(this);

        etname = (EditText)findViewById(R.id.NAME);
        etsurname=(EditText)findViewById(R.id.SURNAME);
        etmarks=(EditText)findViewById(R.id.MARKS);
        addDATA = (Button)findViewById(R.id.dbBTN);
        dbSHOW = (Button)findViewById(R.id.dbSHOW);
        update = (Button)findViewById(R.id.update);
        delete = (Button)findViewById(R.id.Delete);
        id = (EditText)findViewById(R.id.id);
        AddData();
        showData();
        updateData();
        deletedata();
        
    }

    private void deletedata() {
        delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int a = dataBaseHelper.daletedata(id.getText().toString());
                        if(a>0){
                            Toast.makeText(SqliteActi.this,"Data is deleted",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(SqliteActi.this,"Data is not Deletedada "+ a ,Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    private void updateData() {
        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean updated = dataBaseHelper.updatedata(id.getText().toString(),
                                                                    etname.getText().toString(),
                                                                        etsurname.getText().toString(),
                                                                        etmarks.getText().toString());

                    if(updated){
                        Toast.makeText(SqliteActi.this,"Data is updated",Toast.LENGTH_LONG).show();
                    }else{Toast.makeText(SqliteActi.this,"Data is not upadated",Toast.LENGTH_LONG).show();

                    }
                    }
                }
        );
    }

    public void AddData(){
        addDATA.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       boolean isINSERTED = dataBaseHelper.insertDATA(
                                                            etname.getText().toString(),
                                                            etsurname.getText().toString(),
                                                            etmarks.getText().toString());
                        if(isINSERTED){
                            Toast.makeText(SqliteActi.this,"Data is Inserted",Toast.LENGTH_LONG).show();
                        }else{Toast.makeText(SqliteActi.this,"Data is not Inserted",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    public void showData(){
        dbSHOW.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = dataBaseHelper.getAllData();
                        if(res.getCount() == 0){
                            showMSG("ERROR","NOTHING FOUND");
                            return;
                        }

                        StringBuffer sb = new StringBuffer();

                        while (res.moveToNext()){
                            sb.append("ID : "+res.getString(0) + "\n");
                            sb.append("NAME : "+res.getString(1) + "\n");
                            sb.append("SURNAME : "+res.getString(2) + "\n");
                            sb.append("MARKS : "+res.getString(3) + "\n\n");
                        }
                        showMSG("Data",sb.toString());
                    }
                }
        );
    }

    public void showMSG(String title,String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(SqliteActi.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }
}
