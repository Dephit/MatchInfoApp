package com.sergeenko.matchinfoapp.interfaces;

import com.sergeenko.matchinfoapp.models.Root;
import com.sergeenko.matchinfoapp.models.UrlResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface Repository {

    Observable<Root> getMatches(int sport, int id);
    Observable<List<UrlResponse>> getLinks(int sport, int id);
}

