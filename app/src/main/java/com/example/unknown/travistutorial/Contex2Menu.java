package com.example.unknown.travistutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Contex2Menu extends AppCompatActivity {

    private static Map<Integer,String> MSG = null;
    private boolean groupItemVisible =true;
    private Menu theMenu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contex2_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initialize();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        theMenu = menu;
       getMenuInflater().inflate(R.menu.mymenu,theMenu);
       return true;
        // return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.stop){
            groupItemVisible = !groupItemVisible;
            theMenu.setGroupVisible(R.id.other_stuff,groupItemVisible);
        }

        String msg = MSG.get(item.getItemId());
        if(msg != null){
            Toast.makeText(Contex2Menu.this,msg,Toast.LENGTH_SHORT).show();
                    }

        if(item.getItemId() == R.id.no_icon){
            Toast.makeText(Contex2Menu.this,"Inside Acti",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Contex2Menu.this,ThemeActi.class);
            startActivity(i);
        }

        if(item.getItemId() == R.id.ghost){
            Intent b = new Intent(Contex2Menu.this,PrefAct.class);
            startActivity(b);
        }
        return true;
      //  return super.onOptionsItemSelected(item);
    }

    public void initialize(){
        MSG = new HashMap<Integer,String>();
        MSG.put(R.id.stop,"Stop that");
        MSG.put(R.id.no_icon,"There is no any ICON");
        MSG.put(R.id.disabled,"This Menu is Disabled");
        MSG.put(R.id.other_stuff,"Here is some Other Stuff");
        MSG.put(R.id.later,"Later Item");
        MSG.put(R.id.last,"Last Item");
        MSG.put(R.id.non_ghost,"Non ghost Item");
        MSG.put(R.id.ghost,"Ghost Item");
    }
}
