package com.sergeenko.matchinfoapp.interfaces;

import com.sergeenko.matchinfoapp.models.Match;
import com.sergeenko.matchinfoapp.models.Root;
import com.sergeenko.matchinfoapp.models.UrlBody;
import com.sergeenko.matchinfoapp.models.UrlResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    @Headers("Content-Type: application/json")
    @POST("data")
    Observable<Root> getMatches(
            @Body Match body
            );

    @Headers("Content-Type: application/json")
    @POST("video-urls")
    Observable<List<UrlResponse>> getUrls(
            @Body UrlBody body
    );
}

