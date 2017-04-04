package com.example.unknown.travistutorial;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Expandable extends ListActivity {

    String[] list = {"Phone1","Phone2","Phone3","Phone4","Phone5"};
    String[] detail={"1111111","22222222","333333","4444444","66666666"};
    boolean[] visible={false,false,false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_expandable);


        setListAdapter(new MyPhone(this));
    }

    public class MyPhone extends BaseAdapter{
        Context c;
        public void toggle(int position) {
            visible[position] = !visible[position];
            notifyDataSetChanged();
        }


        public MyPhone(Context expandable) {
            c = expandable;
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
            PhoneDetail phoneDetail;
            if(convertView == null){
                phoneDetail = new PhoneDetail(c,list[position],detail[position],visible[position] );
            }
            else{
                phoneDetail = (PhoneDetail)convertView;
                phoneDetail.setName(list[position]);
                phoneDetail.setDetail(detail[position]);
                phoneDetail.setVisible(visible[position]);
            }

            return phoneDetail;
        }
    }

    public class PhoneDetail extends LinearLayout {

        TextView Name;
        TextView Detail;

        public PhoneDetail(Context c, String name, String detail, boolean visible) {
            super(c);
            PhoneDetail.this.setOrientation(VERTICAL);

            Name = new TextView(c);
            Name.setText(name);
            addView(Name, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            Detail = new TextView(c);
            Detail.setText(name);
            addView(Detail, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            Detail.setVisibility(visible ? VISIBLE : GONE);
        }

        public void setName(String s) {
            Name.setText(s);
        }

        public void setDetail(String s){
            Detail.setText(s);
        }

        public void setVisible(boolean b){
            Detail.setVisibility(b ? VISIBLE : GONE);
        }

        }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        ((MyPhone)getListAdapter()).toggle(position);
    }
}
