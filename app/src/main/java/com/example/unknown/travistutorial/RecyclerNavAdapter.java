package com.example.unknown.travistutorial;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by UNKNOWN on 6/27/2016.
 */
public class RecyclerNavAdapter extends RecyclerView.Adapter<RecyclerNavAdapter.RecyclerViewHolder> {

    ArrayList<String> arrayList = new ArrayList<String>();

    RecyclerNavAdapter(ArrayList<String> arrayList){
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerNavAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerNavAdapter.RecyclerViewHolder holder, int position) {

        holder.textView.setText(arrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.tvRecycler);
        }
    }
}
