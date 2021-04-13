package com.sergeenko.matchinfoapp.presenter;

import android.util.Log;

import com.sergeenko.matchinfoapp.interfaces.BaseModel;
import com.sergeenko.matchinfoapp.interfaces.BaseViewInterface;
import com.sergeenko.matchinfoapp.interfaces.PresenterInterface;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class BasePresenter<T extends BaseViewInterface, I extends BaseModel> implements PresenterInterface<T> {

    T view;
    I model;

    public void setObserve(Disposable disposable) {
    }

    @Override
    public void attachView(T view) { this.view = view; }

    public void setComplete() {

    }

    public void setError(Throwable e) {
        view.showToast(e.getLocalizedMessage() );
        Log.e("ERROR", e.getLocalizedMessage());
    }

    public <D>void observe(Observable<D> links,
                            OnSubscribeInterface onSubscribe,
                            OnErrorInterface onError,
                            OnNextInterface<D> onNext,
                            OnCompleteInterface onComplete
    ) {
        links
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                new Observer<D>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        onSubscribe.operation(d);
                    }

                    @Override
                    public void onNext(@NonNull D next) {
                        onNext.operation(next);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        onError.operation(e);
                    }

                    @Override
                    public void onComplete() {
                        onComplete.operation();
                    }
                }
        );
    }

}

