package com.example.unknown.travistutorial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by UNKNOWN on 6/27/2016.
 */
public class RecyclerNavigationAdapter extends RecyclerView.Adapter<RecyclerNavigationAdapter.RecyclerNavigationHolder> {

    ArrayList<ListProvider> arrayList = new ArrayList<>();
    Context context;
    public RecyclerNavigationAdapter( ArrayList<ListProvider> arrayList,Context context){
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public RecyclerNavigationHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list,parent,false);
        RecyclerNavigationHolder recyclerNavigationHolder;
        recyclerNavigationHolder = new RecyclerNavigationHolder(view);
        return recyclerNavigationHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerNavigationHolder holder, int position) {

        ListProvider provider;
        provider = arrayList.get(position);
        holder.imageView.setBackgroundResource(provider.getIcon());
        holder.mName.setText(provider.getmName());
      //  holder.mRating.setText(provider.getmRating());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RecyclerNavigationHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView mName,mRating;

        public RecyclerNavigationHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.icon_movie);
            mName = (TextView)itemView.findViewById(R.id.movie_text);
           // mRating = (TextView)itemView.findViewById(R.id.rating_text);
        }
    }
}
