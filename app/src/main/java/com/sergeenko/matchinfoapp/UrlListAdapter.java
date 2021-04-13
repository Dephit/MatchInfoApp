package com.sergeenko.matchinfoapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class UrlListAdapter extends RecyclerView.Adapter<UrlViewHolder>{

    @Inject
    UrlListAdapter(){

    }

    OnVideoPressed onVideoPressed;

    List<UrlResponse> list;

    public void setList(List<UrlResponse> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public List<UrlResponse> getList() {
        return list;
    }

    @NonNull
    @Override
    public UrlViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UrlViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.url_view, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UrlViewHolder holder, int position) {
            holder.bind(list.get(position), onVideoPressed);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnClickListener(OnVideoPressed o) {
        onVideoPressed = o;
    }
}


interface OnVideoPressed{
    void operation(UrlResponse urlResponse);
}