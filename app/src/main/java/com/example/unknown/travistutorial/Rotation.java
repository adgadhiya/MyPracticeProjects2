package com.example.unknown.travistutorial;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Rotation extends AppCompatActivity {

    static final int PICK_REQUEST = 1337;
    Button view = null;
    Uri contacts = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation);

        Button pick = (Button)findViewById(R.id.pick);
        Button view = (Button)findViewById(R.id.view);

        pick.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                        startActivityForResult(i,0);
                    }
                }
        );

        view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Intent.ACTION_VIEW,contacts));
                    }
                }
        );

        restoreme(savedInstanceState);
        view.setEnabled(contacts!=null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if(requestCode == RESULT_OK){
                Toast.makeText(Rotation.this,"Inside Result Method",Toast.LENGTH_SHORT);
                Bundle bundle = data.getExtras();
                contacts = (Uri) bundle.get("CONTACT");
                view.setEnabled(true);
            }
        }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(contacts!=null){
            outState.putString("contacts",contacts.toString());
        }
    }

    public void restoreme(Bundle State){
        contacts = null;
        if(State!=null) {
            String contactURI = State.getString("contacts");
            if (contactURI != null) {
                contacts = Uri.parse(contactURI);
            }
        }
    }
}
