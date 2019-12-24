package com.example.changex;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule
{
    private MyApplication application;

    public AppModule(MyApplication app)
    {
        application = app;
    }

    @Provides
    @Singleton
    Context provideContext()
    {
        return application.getApplicationContext();
    }

    @Provides
    Application provideApplication()
    {
        return application;
    }
}