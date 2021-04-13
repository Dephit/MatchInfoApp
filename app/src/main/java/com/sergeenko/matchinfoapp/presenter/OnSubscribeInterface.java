package com.sergeenko.matchinfoapp.presenter;

import io.reactivex.rxjava3.disposables.Disposable;

public interface OnSubscribeInterface {
    public void operation(Disposable disposable);
}
