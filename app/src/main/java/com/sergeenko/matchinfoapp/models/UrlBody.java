package com.sergeenko.matchinfoapp.models;

public class UrlBody{
    public int match_id;
    public int sport_id;

    public UrlBody(int match_id, int sport_id){
        this.match_id = match_id;
        this.sport_id = sport_id;
    }
}
