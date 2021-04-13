package com.sergeenko.matchinfoapp;

import android.graphics.ColorSpace;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.Response;

public class RepositoryImpl implements Repository {
    private final Api api;

    public RepositoryImpl(Api api) {
        this.api = api;
    }

    @Override
    public Observable<Root> getMatches(int sport, int id) {
        return api.getMatches(new Match("get_match_info", new Params(sport, id)));
    }

    @Override
    public Observable<List<UrlResponse>> getLinks(int sport, int id) {
        return api.getUrls(new UrlBody(id, sport));
    }
}
