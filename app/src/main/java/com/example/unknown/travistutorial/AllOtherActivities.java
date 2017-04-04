package com.example.unknown.travistutorial;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.StackView;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.BufferedReader;

import static android.R.anim.fade_in;

public class AllOtherActivities extends AppCompatActivity {

    private String[] names;
    private DrawerLayout drawerLayout;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_all_other_activities);

        names = getResources().getStringArray(R.array.planet);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.drawerTV);

   }
}