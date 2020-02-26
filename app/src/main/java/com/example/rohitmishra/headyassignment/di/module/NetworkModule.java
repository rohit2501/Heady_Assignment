package com.example.rohitmishra.headyassignment.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
  @Provides
  GsonConverterFactory providesGsonConverterFactory() {
    Gson gson = new GsonBuilder().setLenient().create();
    return GsonConverterFactory.create();
  }

  @Provides
  RxJava2CallAdapterFactory providesRxJava2CallAdapterFactory() {
    return RxJava2CallAdapterFactory.create();
  }

  @Provides
  OkHttpClient providesOkHttpClient() {
    final int CONNECTION_TIMEOUT = 30;
    final int READ_TIMEOUT = 30;

    OkHttpClient.Builder builder =
        new OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);

    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    builder.addInterceptor(loggingInterceptor);
    return builder.build();
  }
}
