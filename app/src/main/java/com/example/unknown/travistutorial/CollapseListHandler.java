package com.example.unknown.travistutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CollapseListHandler extends AppCompatActivity {

    ListView listView;
    CollapseListAdapter adapter;

    List<String> title = new ArrayList<String>();
    List<String> desc = new ArrayList<String>();

    String[] country;
    String[] capital;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapse_list_handler);

        listView = (ListView)findViewById(R.id.lvCollapse);

        country = getResources().getStringArray(R.array.header);
        capital = getResources().getStringArray(R.array.detail);

        adapter = new CollapseListAdapter(this,R.layout.activity_collapse_list_provider);

        CollapseListProvider collapseListProvider;

        int i=0;

        for(String string : country)    {

            collapseListProvider = new CollapseListProvider(string,capital[i]);
            i++;
        }

        listView.setAdapter(adapter);
    }


}
