package com.sergeenko.matchinfoapp.presenter;

import com.sergeenko.matchinfoapp.interfaces.MainModel;
import com.sergeenko.matchinfoapp.interfaces.MainPresenter;
import com.sergeenko.matchinfoapp.interfaces.MainView;
import com.sergeenko.matchinfoapp.interfaces.Repository;
import com.sergeenko.matchinfoapp.models.Root;
import com.sergeenko.matchinfoapp.models.UrlResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.Disposable;

public class Presenter extends BasePresenter<MainView, MainModel> implements MainPresenter {

    @Inject
    Repository repository;

    @Inject
    Presenter(MainModel model){
        this.model = model;
    }

    @Override
    public void setComplete() {
        view.closeLoading();
    }

    @Override
    public void setObserve(Disposable disposable) {
        view.showLoading();
    }

    @Override
    public void getMatches() {
        observe(
                repository.getMatches(model.getSportID(), model.getMatchID()),
                this::setObserve,
                this::setError,
                this::setTournament,
                this::setComplete
        );
    }

    @Override
    public void getLinks() {
        observe(
                repository.getLinks(model.getSportID(), model.getMatchID()),
                this::setObserve,
                this::setError,
                this::setUrls,
                this::setComplete
        );
    }

    @Override
    public void setError(Throwable e) {
        super.setError(e);
        view.closeLoading();
    }

    private void setUrls(List<UrlResponse> urls) {
        if(model.getUrlList() == null){
            model.setUrlList(urls);
            view.setUrlsList(model.getUrlAdapter());
        }
        //view.updateUrls(urls);
    }

    private void setTournament(Root tournament) {
        model.setTournament(tournament);
        view.updateTournament(tournament);
    }

}

