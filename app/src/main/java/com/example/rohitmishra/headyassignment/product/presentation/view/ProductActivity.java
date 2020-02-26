package com.example.rohitmishra.headyassignment.product.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.rohitmishra.headyassignment.R;
import com.example.rohitmishra.headyassignment.product.model.service.Product;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.rohitmishra.headyassignment.product.presentation.view.ProductCategoryActivity.PRODUCTS;

public class ProductActivity extends AppCompatActivity {

    @BindView(R.id.product_rv)
    RecyclerView productRecyclerView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    ArrayList<Product> productList;

    private ProductViewAdapter productViewAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_selection);
        ButterKnife.bind(this);
        progressBar.setVisibility(View.GONE);
        Intent intent = getIntent();
        productList = (ArrayList<Product>) intent.getSerializableExtra(PRODUCTS);
        productViewAdapter = new ProductViewAdapter(productList);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(ProductActivity.this));
        productRecyclerView.setAdapter(productViewAdapter);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
