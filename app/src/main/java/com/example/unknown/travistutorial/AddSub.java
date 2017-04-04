package com.example.unknown.travistutorial;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AddSub extends AppCompatActivity {

    private String[] list = new String[]{"1List1","List2","1List3","List4","1List5","List6",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sub);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(new MyList(AddSub.this));
    }

    public class MyList extends BaseAdapter{
        Context c;
        public MyList(Context c) {
        this.c = c;
        }

        @Override
        public int getCount() {
            return list.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if(view == null){
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                view = layoutInflater.inflate(R.layout.myicon,parent,false);
            }
            TextView textView = (TextView)view.findViewById(R.id.label);
            ImageView imageView=(ImageView)view.findViewById(R.id.icon);

            textView.setText(list[position]);

            if(list[position].startsWith("1")){
                imageView.setBackgroundResource(R.mipmap.ic_launcher);
            }
            else{
                imageView.setBackgroundResource(R.mipmap.myimage);
            }

            return view;
        }
    }

}
