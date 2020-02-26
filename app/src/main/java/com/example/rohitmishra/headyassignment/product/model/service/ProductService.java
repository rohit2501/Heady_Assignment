package com.example.rohitmishra.headyassignment.product.model.service;

import io.reactivex.Single;

public class ProductService implements ProductServiceContract {
    private final ProductApi productApi;

    public ProductService(ProductApi productApi) {
        this.productApi = productApi;
    }

    @Override
    public Single<Response> getProduct() {
        return productApi.getProduct();
    }
}
