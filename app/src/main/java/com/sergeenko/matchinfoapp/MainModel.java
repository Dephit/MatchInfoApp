package com.sergeenko.matchinfoapp;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public interface MainModel extends BaseModel {

    void setTournament(Root tournament);

    Root getTournament();

    int getSportID();

    int getMatchID();

    List<UrlResponse> getUrlList();

    void setUrlList(List<UrlResponse> urls);

    UrlListAdapter getUrlAdapter();
}
