package com.example.rohitmishra.headyassignment.product.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.rohitmishra.headyassignment.R;
import com.example.rohitmishra.headyassignment.common.HeadyAssignmentApplication;
import com.example.rohitmishra.headyassignment.product.di.ProductViewModelModule;
import com.example.rohitmishra.headyassignment.product.model.service.Category;
import com.example.rohitmishra.headyassignment.product.model.service.Product;
import com.example.rohitmishra.headyassignment.product.presentation.viewmodel.ProductViewModelContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProductCategoryActivity extends AppCompatActivity implements ProductCategoryViewAdapter.ICategorySelectedListener {
    @Inject
    ProductViewModelContract productViewModelContract;

    @BindView(R.id.product_rv)
    RecyclerView productRecyclerView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private ProductCategoryViewAdapter productCategoryViewAdapter;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private List<Category> mCategories;
    public static final String PRODUCTS = "PRODUCTS";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_selection);
        HeadyAssignmentApplication.get(this).getAppComponent().plus(new ProductViewModelModule()).inject(this);
        ButterKnife.bind(this);
        subscribeProductViewModel();
    }

    private void subscribeProductViewModel() {
        productViewModelContract.getProductCategory().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<Category>>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onSuccess(List<Category> categories) {
                mCategories = categories;
                productCategoryViewAdapter = new ProductCategoryViewAdapter(categories, ProductCategoryActivity.this);
                productRecyclerView.setLayoutManager(new LinearLayoutManager(ProductCategoryActivity.this));
                productRecyclerView.setAdapter(productCategoryViewAdapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("Error", e.getMessage());
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }

    @Override
    public void onCategorySelected(Category category) {
        for (int i = 0; i < mCategories.size(); i++) {
            if (category.getId() == mCategories.get(i).getId()) {
                launchProductActivity((ArrayList<Product>) mCategories.get(i).getProducts());
            }
        }

    }

    private void launchProductActivity(ArrayList<Product> products) {
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra(PRODUCTS, products);
        startActivity(intent);
    }
}
