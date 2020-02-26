package com.example.rohitmishra.headyassignment.common;

import android.app.Application;
import android.content.Context;

import com.example.rohitmishra.headyassignment.di.component.AppComponent;
import com.example.rohitmishra.headyassignment.di.component.DaggerAppComponent;
import com.example.rohitmishra.headyassignment.di.module.ApplicationModule;
import com.example.rohitmishra.headyassignment.di.module.NetworkModule;

import javax.inject.Singleton;

public class HeadyAssignmentApplication extends Application {
    private AppComponent appComponent;
    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
        appComponent =
                DaggerAppComponent.builder()
                        .applicationModule(new ApplicationModule(this.getApplicationContext()))
                        .networkModule(new NetworkModule())
                        .build();
        appComponent.inject(this);

    }

    public static HeadyAssignmentApplication get(Context context) {
        return (HeadyAssignmentApplication) context.getApplicationContext();
    }

    @Singleton
    public static Context getInstance() {
        return applicationContext;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
