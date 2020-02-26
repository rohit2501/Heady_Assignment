package com.example.rohitmishra.headyassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.rohitmishra.headyassignment.product.presentation.view.ProductCategoryActivity;
import com.example.rohitmishra.headyassignment.product.presentation.view.ProductRankingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.category_button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.category_button)
    void onCategoryClick() {
        launchCategoryActivity();
    }

    private void launchCategoryActivity() {
        startActivity(new Intent(this, ProductCategoryActivity.class));
    }

    @OnClick(R.id.ranking_button)
    void onRankingClick() {
        launchRankingActivity();
    }

    private void launchRankingActivity() {
        startActivity(new Intent(this, ProductRankingActivity.class));
    }
}
