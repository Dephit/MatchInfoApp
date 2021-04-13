package com.sergeenko.matchinfoapp.model;

import com.sergeenko.matchinfoapp.interfaces.MainModel;
import com.sergeenko.matchinfoapp.models.Root;
import com.sergeenko.matchinfoapp.adapter.UrlListAdapter;
import com.sergeenko.matchinfoapp.models.UrlResponse;

import java.util.List;

import javax.inject.Inject;

public class MainActivityModel implements MainModel {

    @Inject
    MainActivityModel(){

    }

    int sportID = 1;
    int matchID = 1724836;

    Root tournament;

    @Inject
    UrlListAdapter adapter;

    @Override
    public void setTournament(Root tournament) {
        this.tournament = tournament;
    }

    @Override
    public Root getTournament() {
        return tournament;
    }

    @Override
    public int getSportID() {
        return sportID;
    }

    @Override
    public int getMatchID() {
        return matchID;
    }

    @Override
    public List<UrlResponse> getUrlList() {
        return adapter.getList();
    }

    @Override
    public void setUrlList(List<UrlResponse> urls) {
        adapter.setList(urls);
    }

    @Override
    public UrlListAdapter getUrlAdapter() {
        return adapter;
    }
}
