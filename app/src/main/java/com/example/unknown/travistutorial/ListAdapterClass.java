package com.example.unknown.travistutorial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UNKNOWN on 6/26/2016.
 */
public class ListAdapterClass extends RecyclerView.Adapter<ListAdapterClass.ListAdapterHolder> {

    private static final int TYPE_HEAD = 0;
    private static final int TYPE_List = 1;

    ArrayList<ListProvider> arrayList = new ArrayList<ListProvider>();

    public ListAdapterClass(ArrayList<ListProvider> listProvider, MyAdapterListner myAdapterListner){
        this.arrayList = listProvider;
        this.myAdapterListner = myAdapterListner;
    }


    @Override
    public ListAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ListAdapterHolder listAdapterHolder;

        if(viewType == TYPE_HEAD){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_head,parent,false);
            listAdapterHolder = new ListAdapterHolder(view,viewType);
            return listAdapterHolder;
        }
        else if(viewType == TYPE_List){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list,parent,false);
            listAdapterHolder = new ListAdapterHolder(view,viewType);
            return listAdapterHolder;
        }
            return  null;
    }

    @Override
    public void onBindViewHolder(ListAdapterHolder holder, int position) {
        ListProvider mlistProvider = null;

        if(holder.view_type == TYPE_HEAD){
            holder.icon.setText("Poster");
            holder.movie.setText("Movie");
            holder.rating.setText("Rating");
        }
        else if(holder.view_type == TYPE_List){
            mlistProvider = arrayList.get(position - 1);
            holder.icon_movie.setImageResource(mlistProvider.getIcon());
            holder.movie_text.setText(mlistProvider.getmName());
            holder.rating_text.setText(mlistProvider.getmRating());
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size() + 1;
    }


    public class ListAdapterHolder extends RecyclerView.ViewHolder{

        int view_type;

        //List
        ImageView icon_movie;
        TextView movie_text,rating_text;

        //Header
        TextView icon,rating,movie;


        public ListAdapterHolder(View itemView,int view_type) {
            super(itemView);

            if(view_type == TYPE_List){
                icon_movie = (ImageView)itemView.findViewById(R.id.icon_movie);
                movie_text = (TextView)itemView.findViewById(R.id.movie_text);
                rating_text = (TextView)itemView.findViewById(R.id.rating_text);
                this.view_type = 1;

                icon_movie.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myAdapterListner.iconOnClick(v,getAdapterPosition());
                    }
                });

                rating_text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myAdapterListner.ratingOnClick(v,getAdapterPosition());
                    }
                });

                movie_text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myAdapterListner.movieOnClick(v,getAdapterPosition());
                    }
                });

            }

           else  if(view_type == TYPE_HEAD){
                icon = (TextView)itemView.findViewById(R.id.icon);
                rating = (TextView)itemView.findViewById(R.id.rating);
                movie = (TextView)itemView.findViewById(R.id.movie);
                this.view_type = 0;

                icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myAdapterListner.iconOnClick(v,getAdapterPosition());
                    }
                });

                rating.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myAdapterListner.ratingOnClick(v,getAdapterPosition());
                    }
                });

                movie.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myAdapterListner.movieOnClick(v,getAdapterPosition());
                    }
                });

            }

        }
    }

    @Override
    public int getItemViewType(int position) {

        if(position == 0){
            return TYPE_HEAD;
        }
        else{
            return TYPE_List;
        }
  }


    public MyAdapterListner myAdapterListner;

    public interface MyAdapterListner {
        void movieOnClick(View v,int position);
        void ratingOnClick(View v,int position);
        void iconOnClick(View v,int position);
    }

}
