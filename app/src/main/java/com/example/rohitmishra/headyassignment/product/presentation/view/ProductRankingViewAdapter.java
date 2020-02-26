package com.example.rohitmishra.headyassignment.product.presentation.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rohitmishra.headyassignment.R;
import com.example.rohitmishra.headyassignment.product.model.service.Ranking;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductRankingViewAdapter extends RecyclerView.Adapter<ProductRankingViewAdapter.ProductViewHolder> {
    private List<Ranking> rankingList;

    public ProductRankingViewAdapter(List<Ranking> rankingList) {
        this.rankingList = rankingList;
    }

    @NonNull
    @Override

    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        productViewHolder.productTextView.setText(rankingList.get(i).getRanking());

    }

    @Override
    public int getItemCount() {
        return rankingList == null ? 0 : rankingList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_tv)
        TextView productTextView;

        public ProductViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
