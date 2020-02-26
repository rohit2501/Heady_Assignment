package com.example.rohitmishra.headyassignment.di.module;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
  @Provides
  Retrofit provideRetrofit(
      OkHttpClient client,
      GsonConverterFactory factory,
      RxJava2CallAdapterFactory callAdapterFactory) {
    return new Retrofit.Builder()
        .baseUrl("https://stark-spire-93433.herokuapp.com/")
        .client(client)
        .addConverterFactory(factory)
        .addCallAdapterFactory(callAdapterFactory)
        .build();
  }
}
