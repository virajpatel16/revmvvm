package com.example.revmvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieListAdepter extends RecyclerView.Adapter<MovieListAdepter.viewholder> {

    List<Moviemodel>movielist;

    public MovieListAdepter(List<Moviemodel> movielist) {
        notifyDataSetChanged();
        this.movielist = movielist;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
holder.textView.setText(movielist.get(position).getName());
        Glide.with(holder.textView.getContext()).load("http://192.168.0.100/api/images/"+movielist.get(position).getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movielist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
ImageView imageView;
TextView textView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);
            textView=itemView.findViewById(R.id.txt);
        }
    }
}

