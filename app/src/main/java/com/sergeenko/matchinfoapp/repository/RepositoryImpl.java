package com.sergeenko.matchinfoapp.repository;

import com.sergeenko.matchinfoapp.interfaces.Api;
import com.sergeenko.matchinfoapp.interfaces.Repository;
import com.sergeenko.matchinfoapp.models.Match;
import com.sergeenko.matchinfoapp.models.Params;
import com.sergeenko.matchinfoapp.models.Root;
import com.sergeenko.matchinfoapp.models.UrlBody;
import com.sergeenko.matchinfoapp.models.UrlResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

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
