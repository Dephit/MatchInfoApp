package com.sergeenko.matchinfoapp.module;

import com.sergeenko.matchinfoapp.interfaces.MainModel;
import com.sergeenko.matchinfoapp.interfaces.MainPresenter;
import com.sergeenko.matchinfoapp.model.MainActivityModel;
import com.sergeenko.matchinfoapp.presenter.Presenter;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public abstract class AppModule {

    @Binds
    public abstract MainPresenter bindMainPresenter(Presenter model);

    @Binds
    public abstract MainModel bindMainModel(MainActivityModel model);
}


