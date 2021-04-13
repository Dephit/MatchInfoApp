package com.sergeenko.matchinfoapp;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
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


/*
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

@Singleton
@Provides
    fun provideYourDatabase(
@ApplicationContext app: Context
        ) = Room.databaseBuilder(app, AppDatabase::class.java, "look_db")
        .fallbackToDestructiveMigration()
        .build()

@Provides
    fun provideChannelDao(appDatabase: AppDatabase): CountryCodeDao {
            return appDatabase.countryCodeDao()
            }

@Provides
    fun provideCodeDao(appDatabase: AppDatabase): CodeDao {
            return appDatabase.codeDao()
            }

@Provides
    fun provideBrandDao(appDatabase: AppDatabase): BrandDao {
            return appDatabase.brandDao()
            }

@Provides
    fun provideCurrencyDao(appDatabase: AppDatabase): CurrencyDao {
            return appDatabase.currencyDao()
            }

@Provides
    fun provideTypeDao(appDatabase: AppDatabase): TypeDao {
            return appDatabase.typeDao()
            }
            }*/
