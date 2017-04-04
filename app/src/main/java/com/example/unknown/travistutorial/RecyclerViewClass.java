package com.example.unknown.travistutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewClass extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ListProvider> arrayList = new ArrayList<ListProvider>();

    String [] mName;
    String [] mRating;

    int[] poster = {R.mipmap.first,R.mipmap.first2,R.mipmap.first3,
                     R.mipmap.first4,R.mipmap.first5,R.mipmap.first6,
                    R.mipmap.first,R.mipmap.first2,R.mipmap.first3,R.mipmap.first4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_class);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        int cnt=0;

        mName = getResources().getStringArray(R.array.movie);
        mRating = getResources().getStringArray(R.array.rating);

        for(String name:mName){

            ListProvider listProvider = new ListProvider(poster[cnt],name,mRating[cnt]);
            arrayList.add(listProvider);
            cnt++;
        }
        adapter = new ListAdapterClass(arrayList, new ListAdapterClass.MyAdapterListner() {
            @Override
            public void movieOnClick(View v, int position) {
                Toast.makeText(RecyclerViewClass.this, "movie clicked " + position , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void ratingOnClick(View v, int position) {
                Toast.makeText(RecyclerViewClass.this, "rating clicked " + position , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void iconOnClick(View v, int position) {
                Toast.makeText(RecyclerViewClass.this, "icon clicked " + position , Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
