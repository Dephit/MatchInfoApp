package com.sergeenko.matchinfoapp;

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
        return adapter.list;
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
