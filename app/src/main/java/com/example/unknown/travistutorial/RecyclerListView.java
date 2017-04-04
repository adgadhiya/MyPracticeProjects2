package com.example.unknown.travistutorial;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by UNKNOWN on 6/27/2016.
 */
public class RecyclerListView extends RecyclerView.Adapter<RecyclerListView.RecyclerListViewHolder> {

    ArrayList<ListProvider> arrayList = new ArrayList<>();

    public RecyclerListView(ArrayList<ListProvider> arrayList){
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerListView.RecyclerListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list,parent,false);
        RecyclerListViewHolder recyclerListViewHolder = new RecyclerListViewHolder(view);
        return recyclerListViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerListView.RecyclerListViewHolder holder, int position) {

        ListProvider listProvider = null;
        listProvider = arrayList.get(position);
        holder.mName.setText(listProvider.getmName());
        holder.mRating.setText(listProvider.getmRating());
        holder.icon.setBackgroundResource(listProvider.getIcon());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RecyclerListViewHolder extends RecyclerView.ViewHolder{

        ImageView icon;
        TextView mName,mRating;

        public RecyclerListViewHolder(View itemView) {
            super(itemView);

            icon = (ImageView)itemView.findViewById(R.id.icon_movie);
            mName = (TextView)itemView.findViewById(R.id.movie_text);
            mRating = (TextView)itemView.findViewById(R.id.rating_text);

        }
    }
}
