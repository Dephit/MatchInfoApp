package com.sergeenko.matchinfoapp;

import android.widget.Adapter;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public interface MainView extends BaseViewInterface {

    void updateTournament(Root tournament);
    void updateUrls(List<UrlResponse> urlResponse);
    void setUrlsList(UrlListAdapter adapter);
    void showLoading();
    void closeLoading();
}
