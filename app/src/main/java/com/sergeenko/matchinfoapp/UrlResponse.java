package com.sergeenko.matchinfoapp;

public class UrlResponse{
    public String name;
    public int match_id;
    public int period;
    public int server_id;
    public String quality;
    public String folder;
    public String video_type;
    public String abc;
    public int start_ms;
    public Object checksum;
    public int size;
    public String abc_type;
    public int duration;
    public int fps;
    public String url_root;
    public String url;

    @Override
    public String toString() {
        return "UrlResponse{" +
                "name='" + name + '\'' +
                ", match_id=" + match_id +
                ", period=" + period +
                ", server_id=" + server_id +
                ", quality='" + quality + '\'' +
                ", folder='" + folder + '\'' +
                ", video_type='" + video_type + '\'' +
                ", abc='" + abc + '\'' +
                ", start_ms=" + start_ms +
                ", checksum=" + checksum +
                ", size=" + size +
                ", abc_type='" + abc_type + '\'' +
                ", duration=" + duration +
                ", fps=" + fps +
                ", url_root='" + url_root + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
