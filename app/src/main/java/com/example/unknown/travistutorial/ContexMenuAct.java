package com.example.unknown.travistutorial;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ContexMenuAct extends AppCompatActivity {

    ListView ContList;
    TextView ContText;

    final static String[] names = {"India","Bhutan","Srilanka","Doodle","Google","Yahoo","Mozila"};

    private static final int MENU_NEW_GAME = Menu.FIRST;
    private static final int MENU_QUIT = Menu.FIRST + 1;
    private static final int MENU_EDIT = Menu.FIRST + 2;
    private static final int MENU_DELETE = Menu.FIRST + 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contex_menu2);
        ContList = (ListView)findViewById(R.id.ContList);

        ArrayAdapter<String> list = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        ContList.setAdapter(list);
        registerForContextMenu(ContList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_NEW_GAME: return true;
            case MENU_QUIT : return true;
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v.getId() == R.id.ContList){
           AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle(names[info.position]);
            menu.add(0,MENU_EDIT,0,"8dp dif").setIcon(R.mipmap.ic_launcher);
            menu.add(0,MENU_DELETE,0,"16dp diff").setIcon(R.mipmap.ic_launcher);

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ContText = (TextView)findViewById(R.id.tvCont);
        switch (item.getItemId()){
            case MENU_EDIT:
                ContText.setText("Edit Selected");
                ContList.setDividerHeight(8);
                break;
            case MENU_DELETE:
                ContText.setText("Delete Selected");
                ContList.setDividerHeight(16);
                break;
        }

        //return true;
        return super.onContextItemSelected(item);
    }
}
