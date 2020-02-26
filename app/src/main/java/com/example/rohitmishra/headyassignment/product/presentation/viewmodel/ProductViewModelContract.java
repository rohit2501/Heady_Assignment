package com.example.rohitmishra.headyassignment.product.presentation.viewmodel;

import com.example.rohitmishra.headyassignment.product.model.service.Category;
import com.example.rohitmishra.headyassignment.product.model.service.Ranking;

import java.util.List;

import io.reactivex.Single;

public interface ProductViewModelContract {

  /**
   * @param
   * @return
   */
  Single<List<Category>> getProductCategory();

  Single<List<Ranking>> getProductRanking();
}
