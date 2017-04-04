package com.example.unknown.travistutorial;

import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class NavigationRecyclerView extends AppCompatActivity {
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    DrawerLayout drawerLayout;
    RecyclerView.LayoutManager layoutManager;

    String[] string;
    ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_recycler_view);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerViewNav);
        toolbar = (Toolbar)findViewById(R.id.myToolbar);
       // ActionBar actionBar = getSupportActionBar();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        string = getResources().getStringArray(R.array.movies);

        for(String name : string){
            arrayList.add(name);
        }
        drawerLayout = (DrawerLayout)findViewById(R.id.dl);
        adapter = new RecyclerNavAdapter(arrayList);

        recyclerView.setAdapter(adapter);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.app_name,R.string.app_name);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}
