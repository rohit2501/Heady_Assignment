package com.example.rohitmishra.headyassignment.product.model.service;

import io.reactivex.Single;

public interface ProductServiceContract {

    /**
     * Used to get {@link Single<Response>} from {@link ProductApi}
     *
     * @return
     */
    Single<Response> getProduct();
}
