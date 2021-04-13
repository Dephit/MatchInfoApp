package com.sergeenko.matchinfoapp.models;

public class Tournament{
    public int id;
    public String name_eng;
    public String name_rus;

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", name_eng='" + name_eng + '\'' +
                ", name_rus='" + name_rus + '\'' +
                '}';
    }
}
