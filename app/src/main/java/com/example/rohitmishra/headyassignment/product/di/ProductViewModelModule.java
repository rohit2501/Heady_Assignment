package com.example.rohitmishra.headyassignment.product.di;

import com.example.rohitmishra.headyassignment.product.model.service.ProductServiceContract;
import com.example.rohitmishra.headyassignment.product.presentation.viewmodel.ProductViewModel;
import com.example.rohitmishra.headyassignment.product.presentation.viewmodel.ProductViewModelContract;
import com.example.rohitmishra.headyassignment.di.annotations.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductViewModelModule {

  public ProductViewModelModule() {
    // blank constructor
  }

  @ActivityScope
  @Provides
  ProductViewModelContract providesProductViewModelContract(ProductServiceContract productServiceContract) {
    return new ProductViewModel(productServiceContract);
  }
}
