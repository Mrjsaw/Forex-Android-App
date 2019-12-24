package com.example.changex;

import android.app.Application;


public class MyApplication extends Application {

    static private AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent()
    {
        return sAppComponent;
    }
}
