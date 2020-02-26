package com.example.rohitmishra.headyassignment.product.di;

import com.example.rohitmishra.headyassignment.product.model.service.ProductApi;
import com.example.rohitmishra.headyassignment.product.model.service.ProductService;
import com.example.rohitmishra.headyassignment.product.model.service.ProductServiceContract;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ProductModelModule {

  public ProductModelModule() {
    // blank constructor
  }

  @Provides
  ProductServiceContract providesProductService(ProductApi productApi) {
    return new ProductService(productApi);
  }

  @Provides
  ProductApi providesProductyApi(Retrofit retrofit) {
    return retrofit.create(ProductApi.class);
  }
}
