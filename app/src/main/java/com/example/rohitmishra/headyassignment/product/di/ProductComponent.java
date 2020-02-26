package com.example.rohitmishra.headyassignment.product.di;

import com.example.rohitmishra.headyassignment.product.presentation.view.ProductRankingActivity;
import com.example.rohitmishra.headyassignment.product.presentation.view.ProductCategoryActivity;
import com.example.rohitmishra.headyassignment.di.annotations.ActivityScope;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ProductModelModule.class, ProductViewModelModule.class})
public interface ProductComponent {
  void inject(ProductCategoryActivity activity);

  void inject(ProductRankingActivity activity);
}
