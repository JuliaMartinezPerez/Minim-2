package com.example.restclientservweb;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class BadgesAdapter extends RecyclerView.Adapter<BadgesAdapter.ViewHolder>{
    private LayoutInflater mInflater;
    private List<Badge> badges;


    public BadgesAdapter(Context context, List<Badge> badges) {
        this.badges = badges;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BadgesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_badges, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull BadgesAdapter.ViewHolder holder, int position) {
        Badge badge = badges.get(position);
        holder.txtView.setText(badge.getName());
        Picasso.get().load(badge.getUrlAvatar()).into(holder.imageView);
        Log.d("JULIA", badge.getUrlAvatar());

    }

    @Override
    public int getItemCount() {
        return badges.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtView;
        public ImageView imageView;
        ViewHolder(View itemView) {
            super(itemView);
            txtView = itemView.findViewById(R.id.txtView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
