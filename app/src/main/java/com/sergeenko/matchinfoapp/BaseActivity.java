package com.sergeenko.matchinfoapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import javax.inject.Inject;

public abstract class BaseActivity<T extends PresenterInterface, S extends ViewBinding> extends AppCompatActivity implements BaseViewInterface {

    S binding;

    @Inject
    T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = bind(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter.attachView(this);
    }

    abstract S bind(LayoutInflater layoutInflater);

    @Override
    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
