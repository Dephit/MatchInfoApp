package com.sergeenko.matchinfoapp;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sergeenko.matchinfoapp.databinding.UrlViewBinding;

public class UrlViewHolder extends RecyclerView.ViewHolder{

    UrlViewBinding binding;

    public UrlViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = UrlViewBinding.bind(itemView);
    }


    public void bind(UrlResponse urlResponse, OnVideoPressed onVideoPressed) {
        /*binding.name.setText(String.valueOf(urlResponse.name));*/
        binding.quality.setText(urlResponse.quality);
        binding.period.setText("period " + urlResponse.period);
        binding.getRoot().setOnClickListener(
                (view)->{
                    onVideoPressed.operation(urlResponse);
                }
        );
    }
}
