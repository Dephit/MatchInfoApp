package com.sergeenko.matchinfoapp.module;

import com.sergeenko.matchinfoapp.BuildConfig;
import com.sergeenko.matchinfoapp.repository.RepositoryImpl;
import com.sergeenko.matchinfoapp.interfaces.Api;
import com.sergeenko.matchinfoapp.interfaces.Repository;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
@InstallIn(ApplicationComponent.class)
public class ApiModule {

    @Singleton
    @Provides
    Api provideApi() {
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .callTimeout(60L, TimeUnit.SECONDS)
                .connectTimeout(60L, TimeUnit.SECONDS)
                .readTimeout(60L, TimeUnit.SECONDS)
                .writeTimeout(60L, TimeUnit.SECONDS)
                .addInterceptor(logger)
            .build();

        RxJava3CallAdapterFactory rxAdapter = RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io());

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .client(client)
                .build()
                .create(Api.class);
    }

    @Singleton
    @Provides
    Repository provideRepository(Api api) {
        return  new RepositoryImpl(api);
    }
}
