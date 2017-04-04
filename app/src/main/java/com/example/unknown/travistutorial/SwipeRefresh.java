package com.example.unknown.travistutorial;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class SwipeRefresh extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout refreshLayout;

    private ListView listView;
    private ArrayAdapter<String> adapter ;

    private String[] movie;
    private String[] movies;

    private List<String> list;

    boolean refreshToggle = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);

        refreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_view);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeColors(Color.GRAY,Color.GREEN,Color.BLUE,Color.RED,Color.CYAN);
        refreshLayout.setDistanceToTriggerSync(20);
        refreshLayout.setSize(SwipeRefreshLayout.DEFAULT);

        movie = getResources().getStringArray(R.array.movie);
        movies = getResources().getStringArray(R.array.movies);

        list = Arrays.asList(movie);

        listView = (ListView)findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(this,R.layout.list_item,list);
        listView.setAdapter(adapter);
        listView.requestLayout();
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(refreshToggle){
                refreshToggle = false;
                list = Arrays.asList(movies);
                adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item,list);
            }
            else{
                refreshToggle = true;
                list = Arrays.asList(movie);
                adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item,list);
            }

            listView.setAdapter(adapter);

            refreshLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(),"Movie List Refreshed",Toast.LENGTH_SHORT).show();
                    refreshLayout.setRefreshing(false);
                }
            } , 1000);
        }
    };

    @Override
    public void onRefresh() {

           refreshLayout.postDelayed(new Runnable() {
               @Override
               public void run() {
                   refreshLayout.setRefreshing(true);
                   handler.sendEmptyMessage(0);
               }
           } , 1000);
    }
}
