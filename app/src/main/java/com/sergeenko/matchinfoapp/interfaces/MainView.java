package com.sergeenko.matchinfoapp.interfaces;

import com.sergeenko.matchinfoapp.models.Root;
import com.sergeenko.matchinfoapp.adapter.UrlListAdapter;
import com.sergeenko.matchinfoapp.models.UrlResponse;

import java.util.List;

public interface MainView extends BaseViewInterface {

    void updateTournament(Root tournament);
    void updateUrls(List<UrlResponse> urlResponse);
    void setUrlsList(UrlListAdapter adapter);
    void showLoading();
    void closeLoading();
}
