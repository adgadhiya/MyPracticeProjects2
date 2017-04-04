package com.example.unknown.travistutorial;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.InputStream;

public class AllClasses extends Activity {

    private ListView listView;
    private String[] myClasses = {"StickyHeader","AddSub","Random","MultiRows","CollapseRow","Expandable",
                                   "EmailActi","CameraActi","Acti2Acti","TabWidgetHost",
                                    "MyGal","ImgSvch","MyFlip","ContexMenuAct","Contex2Menu",
                                    "GFX","GFXSurface","sliding","Lati_Longi","Rotation","ConfigRotation",
                                    "ConfigChange","SharedPrefs","FileActivity",
                                    "TaskAsync","ExternalStore","SqliteActi","AllOtherActivities"
                                    ,"BinderMainClass","MessengerMainClass","IpcMainClass"
                                    ,"SwipeViewCLass","ImageSliderlass","NavigationDrawerClass","RecyclerViewClass",
                                     "NavigationRecyclerView","RecyclerNavigationViewProvider","SwipeRefresh",
                                    "SimpleBlurr","SQLiteDataBaseClass","SQLiteActivityClass","TimerTaskExecution"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_classes);
        listView = (ListView)findViewById(R.id.listView);
        listView.setTextFilterEnabled(true);
        listView.setAdapter(new ArrayAdapter<String>(AllClasses.this,android.R.layout.simple_list_item_1,myClasses));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mystring = myClasses[position];
                try {
                    Class ActivityClass = Class.forName("com.example.unknown.travistutorial." + mystring);
                    Intent intent = new Intent(AllClasses.this,ActivityClass);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
