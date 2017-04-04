package com.example.unknown.travistutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by UNKNOWN on 6/24/2016.
 */
public class CollapseListAdapter extends ArrayAdapter {

    Context context;
    List list;


    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    public CollapseListAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class Items{
        TextView name;
        TextView detail;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        Items items;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_collapse_list_provider,parent,false);

            items = new Items();
            items.name = (TextView)view.findViewById(R.id.tvCollapse);
            items.detail = (TextView)view.findViewById(R.id.tvCollapse2);

            view.setTag(items);
        }else{
            items = (Items)view.getTag();
        }

        CollapseListProvider collapseListProvider = new CollapseListProvider(context);

        items.name.setText(collapseListProvider.getHeading());
        items.detail.setText(collapseListProvider.getDescription());

        return view;

    }
}
