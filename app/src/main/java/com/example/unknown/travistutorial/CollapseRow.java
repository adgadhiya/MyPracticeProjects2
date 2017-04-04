package com.example.unknown.travistutorial;

import android.app.ExpandableListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollapseRow extends ExpandableListActivity {

    public static final String Group = "Group";
    public static final String Name = "Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_collapse_row);

        List<Map<String,String>> group = new ArrayList<Map<String, String>>();
        List<List<Map<String,String>>> childGroup = new ArrayList<List<Map<String,String>>>();

        ExpandableListAdapter expandableListAdapter;

        for(int i=0 ; i<10 ; i++){
            Map<String,String> myGroup = new HashMap<String, String>();
            group.add(myGroup);
            myGroup.put(Group,"Group"+i);
            myGroup.put(Name,"Name"+ (i+1));

            List<Map<String,String>> children = new ArrayList<Map<String, String>>();
            for(int j=0;j<3;j++){
                Map<String,String> child = new HashMap<String, String>();
                children.add(child);
                child.put("Group","Child"+j);
                child.put("Name","Name"+(j+1));
            }
            childGroup.add(children);
        }

        expandableListAdapter = new SimpleExpandableListAdapter(
                            this,
                            group,
                            R.layout.activity_collapse_row,
                            new String[] {Group,Name},
                            new int[] {R.id.tv1,R.id.tv2},
                            childGroup,
                            R.layout.activity_collapse_row,
                            new String[] {Group,Name},
                            new int[] {R.id.tv1,R.id.tv2}
                                                                 );

        setListAdapter(expandableListAdapter);
    }




}
