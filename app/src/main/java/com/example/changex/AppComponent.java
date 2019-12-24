package com.example.changex;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules= {AppModule.class})
public interface AppComponent {
    void inject(MyApplication application);
    @Component.Builder
    interface Builder {
        AppComponent build();
        Builder appModule(AppModule appModule);
    }
}
