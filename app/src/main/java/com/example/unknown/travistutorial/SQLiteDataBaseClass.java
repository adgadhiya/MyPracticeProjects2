package com.example.unknown.travistutorial;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQLiteDataBaseClass extends AppCompatActivity implements View.OnClickListener {

    EditText etNAME,etSURNAME,etID,etMARKS;
    Button DELETE,UPDATE,INSERT,VIEW;

    SQLiteDataBaseHelperClass dataBaseHelperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_data_base_class);

        dataBaseHelperClass = new SQLiteDataBaseHelperClass(this);

        etNAME = (EditText)findViewById(R.id.etNAME);
        etSURNAME = (EditText)findViewById(R.id.etSURNAME);
        etID = (EditText)findViewById(R.id.etID);
        etMARKS = (EditText)findViewById(R.id.etMARKS);

        DELETE = (Button)findViewById(R.id.DELETE);
        VIEW = (Button)findViewById(R.id.VIEW);
        INSERT = (Button)findViewById(R.id.INSERT);
        UPDATE = (Button)findViewById(R.id.UPDATE);

        DELETE.setOnClickListener(this);
        VIEW.setOnClickListener(this);
        INSERT.setOnClickListener(this);
        UPDATE.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case  R.id.INSERT:

                boolean success = dataBaseHelperClass.insertData(etNAME.getText().toString(),etSURNAME.getText().toString()
                                                ,etMARKS.getText().toString());

                if(success){
                    displayResult("Successful","DATA Inserted successfully");
                }
                else{
                    displayResult("ERROR","DATA did not Inserted");
                }

                 break;

            case R.id.UPDATE:

                boolean updated = dataBaseHelperClass.upData(etNAME.getText().toString(),etSURNAME.getText().toString(),
                                                              etMARKS.getText().toString(),etID.getText().toString());
                if(updated){
                    displayResult("Successfull","Data Updated Successfully");
                }
                else{
                    displayResult("ERROR","Data could not be updated");
                }

                break;

            case R.id.VIEW:

                Cursor res = dataBaseHelperClass.viewAllData(etNAME.getText().toString());

                if(res.getCount() > 0){

                    StringBuilder sb = new StringBuilder();

                    while (res.moveToNext()){
                        sb.append("ID: " + res.getString(0) + "\n");
                        sb.append("NAME: " + res.getString(1) + "\n");
                        sb.append("SURNAME: " + res.getString(2) + "\n");
                        sb.append("MARKS: " + res.getString(3) + "\n\n");
                    }

                    displayResult("Data From Table",sb.toString());
                }
                else{
                    displayResult("WARNING","Please First insert the data");
                }

                break;

            case R.id.DELETE:

                Toast.makeText(this,"Button Clicked",Toast.LENGTH_LONG).show();
                boolean deleted = dataBaseHelperClass.deleteData(etID.getText().toString());

                if(deleted){
                    displayResult("Succesful","Data Delete From index" + etID.getText().toString());
                }
                else {
                    displayResult("ERROR!!","Some Error Occured Please Check the Code");
                }

                break;

        }
    }

    public void displayResult(String error,String msg){

        AlertDialog.Builder builder = new AlertDialog.Builder(this,android.R.style.ThemeOverlay_Material_Dialog_Alert);
        builder.setTitle(error);
        builder.setMessage(msg);
        builder.setPositiveButton("OK",null);
        builder.show();

    }
}
