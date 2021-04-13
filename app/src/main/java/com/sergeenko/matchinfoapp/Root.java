package com.sergeenko.matchinfoapp;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Root{
    public Tournament tournament;
    public String date;
    public Team1 team1;
    public Team2 team2;
    public int stream_status;

    @NotNull
    @Override
    public String toString() {
        return "Root{" +
                "tournament=" + tournament +
                ", date=" + date +
                ", team1=" + team1 +
                ", team2=" + team2 +
                ", stream_status=" + stream_status +
                '}';
    }
}
