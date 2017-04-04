package com.example.unknown.travistutorial;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiRows extends ListActivity {

    static final ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
    static final ArrayList<HashMap<String,Integer>> list2 = new ArrayList<HashMap<String, Integer>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_multi_rows);

//        SimpleAdapter adapter = new SimpleAdapter
//                (this,
//                        list,
//                        R.layout.rows,
//                        new String[] {"Author","Name","Price","image"},
//                        new int [] {R.id.Author,R.id.Name,R.id.Price,R.id.imageView});

        SimpleAdapter adapter2 = new SimpleAdapter
                (this,
                        list2,
                        R.layout.rows,
                        new String[] {"Author","Name","Price","image"},
                        new int [] {R.id.Author,R.id.Name,R.id.Price,R.id.imageView});

        populate();
//        setListAdapter(adapter);
        setListAdapter(adapter2);
    }

    void populate(){
        HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
        HashMap<String,String> map = new HashMap<String, String>();

//        hashMap.put("Author",Integer.parseInt("Author1"));
//        hashMap.put("Name",Integer.parseInt("Name1"));
        hashMap.put("Price",Integer.parseInt("100"));
        hashMap.put("image",R.mipmap.first3);
        list2.add(hashMap);


        hashMap = new HashMap<String, Integer>();
 //       hashMap.put("Author",Integer.parseInt("Author2"));
 //       hashMap.put("Name",Integer.parseInt("Name2"));
        hashMap.put("Price",Integer.parseInt("1000"));
        hashMap.put("image",R.mipmap.first4);
        list2.add(hashMap);

        hashMap = new HashMap<String, Integer>();
 //       hashMap.put("Author",Integer.parseInt("Author3"));
 //       hashMap.put("Name",Integer.parseInt("Name3"));
        hashMap.put("Price",Integer.parseInt("1002"));
        hashMap.put("image",R.mipmap.first5);
        list2.add(hashMap);

        hashMap = new HashMap<String, Integer>();
//        hashMap.put("Author",Integer.parseInt("Aufaethor1"));
//        hashMap.put("Name",Integer.parseInt("Nagrgqme1"));
        hashMap.put("Price",Integer.parseInt("104440"));
        hashMap.put("image",R.mipmap.first6);
        list2.add(hashMap);
    }
}
