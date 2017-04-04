package com.example.unknown.travistutorial;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FastSearchListView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_search_list_view);
/*
        List<String> countries = new ArrayList<String>();

        String[] names = getResources().getStringArray(R.array.movies);

        countries = Arrays.asList(names);

        Collections.sort(countries);

        FastSearchListViewHandler listViewHandler = (FastSearchListViewHandler)findViewById(R.id.);

        SimpleAdapter sa = new SimpleAdapter(this,countries);
        listViewHandler.setAdapter(sa);  */
    }
}
