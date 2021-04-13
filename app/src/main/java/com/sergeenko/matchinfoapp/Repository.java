package com.sergeenko.matchinfoapp;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.Response;

public interface Repository {

    Observable<Root> getMatches(int sport, int id);
    Observable<List<UrlResponse>> getLinks(int sport, int id);
}

