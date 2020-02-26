package com.example.rohitmishra.headyassignment.product.model.service;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ProductApi {

  @GET("json/")
  Single<Response> getProduct();
}
