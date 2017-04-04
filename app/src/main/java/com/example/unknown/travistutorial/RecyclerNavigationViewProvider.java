package com.example.unknown.travistutorial;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerNavigationViewProvider extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.Adapter thisAdapter;
    RecyclerView.LayoutManager layoutManager;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    ArrayList<ListProvider> arrayList = new ArrayList<>();

    int[] images = {R.mipmap.first,R.mipmap.first2,R.mipmap.first3,R.mipmap.first4,R.mipmap.first5,
                    R.mipmap.first,R.mipmap.first2,R.mipmap.first3,R.mipmap.first4,R.mipmap.first5};

    String[] mName,mRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_navigation_view_provider);

        toolbar = (Toolbar)findViewById(R.id.navigationRecycler);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayoutNavRecy);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerNavigation);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mName = getResources().getStringArray(R.array.movie);
        mRating = getResources().getStringArray(R.array.rating);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.app_name,R.string.app_name);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        setSupportActionBar(toolbar);

        int cnt=0;

        for(String name : mName){
           ListProvider listProvider = new ListProvider(images[cnt],name,mName[cnt]);
            arrayList.add(listProvider);
            cnt++;
        }
        thisAdapter = new RecyclerNavigationAdapter(arrayList,this);
        recyclerView.setAdapter(thisAdapter);

    }
}
