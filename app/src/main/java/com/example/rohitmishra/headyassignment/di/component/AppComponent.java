package com.example.rohitmishra.headyassignment.di.component;

import com.example.rohitmishra.headyassignment.common.HeadyAssignmentApplication;
import com.example.rohitmishra.headyassignment.product.di.ProductComponent;
import com.example.rohitmishra.headyassignment.product.di.ProductViewModelModule;
import com.example.rohitmishra.headyassignment.di.annotations.ApplicationScope;
import com.example.rohitmishra.headyassignment.di.module.ApiModule;
import com.example.rohitmishra.headyassignment.di.module.ApplicationModule;
import com.example.rohitmishra.headyassignment.di.module.NetworkModule;
import dagger.Component;

@ApplicationScope
@Component(modules = {ApplicationModule.class, NetworkModule.class, ApiModule.class})
public interface AppComponent {
  void inject(HeadyAssignmentApplication application);

  ProductComponent plus(ProductViewModelModule productViewModelModule);
  
}
