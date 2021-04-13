package com.sergeenko.matchinfoapp.interfaces;

import com.sergeenko.matchinfoapp.models.Root;
import com.sergeenko.matchinfoapp.adapter.UrlListAdapter;
import com.sergeenko.matchinfoapp.models.UrlResponse;

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
