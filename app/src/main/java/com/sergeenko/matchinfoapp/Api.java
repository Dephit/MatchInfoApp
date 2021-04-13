package com.sergeenko.matchinfoapp;

import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

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

