package com.example.rohitmishra.headyassignment.product.presentation.viewmodel;

import com.example.rohitmishra.headyassignment.product.model.service.Category;
import com.example.rohitmishra.headyassignment.product.model.service.ProductServiceContract;
import com.example.rohitmishra.headyassignment.product.model.service.Ranking;
import com.example.rohitmishra.headyassignment.product.model.service.Response;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class ProductViewModel implements ProductViewModelContract {
    private final ProductServiceContract serviceContract;

    public ProductViewModel(ProductServiceContract serviceContract) {
        this.serviceContract = serviceContract;
    }

    @Override
    public Single<List<Category>> getProductCategory() {
        return serviceContract.getProduct().map(new Function<Response, List<Category>>() {
            @Override
            public List<Category> apply(Response response) throws Exception {
                return response.getCategories();
            }
        });
    }

    @Override
    public Single<List<Ranking>> getProductRanking() {
        return serviceContract.getProduct().map(new Function<Response, List<Ranking>>() {
            @Override
            public List<Ranking> apply(Response response) throws Exception {
                return response.getRankings();
            }
        });
    }
}
