package com.example.rohitmishra.headyassignment.product.presentation.view;

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
import com.example.rohitmishra.headyassignment.product.model.service.Ranking;
import com.example.rohitmishra.headyassignment.product.presentation.viewmodel.ProductViewModelContract;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProductRankingActivity extends AppCompatActivity {

    @Inject
    ProductViewModelContract productViewModelContract;

    @BindView(R.id.product_rv)
    RecyclerView productRecyclerView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private ProductRankingViewAdapter productRankingViewAdapter;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_selection);
        HeadyAssignmentApplication.get(this).getAppComponent().plus(new ProductViewModelModule()).inject(this);
        ButterKnife.bind(this);
        subscribeProductViewModel();
    }

    private void subscribeProductViewModel() {
        productViewModelContract.getProductRanking().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<Ranking>>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onSuccess(List<Ranking> rankings) {
                progressBar.setVisibility(View.GONE);
                productRankingViewAdapter = new ProductRankingViewAdapter(rankings);
                productRecyclerView.setLayoutManager(new LinearLayoutManager(ProductRankingActivity.this));
                productRecyclerView.setAdapter(productRankingViewAdapter);
            }

            @Override
            public void onError(Throwable e) {
                progressBar.setVisibility(View.GONE);
                Log.d("Error", e.getMessage());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
