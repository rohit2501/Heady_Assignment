package com.example.rohitmishra.headyassignment.product.presentation.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rohitmishra.headyassignment.R;
import com.example.rohitmishra.headyassignment.product.model.service.Category;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductCategoryViewAdapter extends RecyclerView.Adapter<ProductCategoryViewAdapter.ProductViewHolder> {
    private List<Category> productCategoryItems;
    ICategorySelectedListener categorySelectedListener;

    public ProductCategoryViewAdapter(List<Category> productCategoryItems, ICategorySelectedListener categorySelectedListener) {
        this.productCategoryItems = productCategoryItems;
        this.categorySelectedListener = categorySelectedListener;
    }

    @NonNull
    @Override

    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, final int i) {
        productViewHolder.productTextView.setText(productCategoryItems.get(i).getName());
        productViewHolder.productTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categorySelectedListener.onCategorySelected(productCategoryItems.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return productCategoryItems == null ? 0 : productCategoryItems.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_tv)
        TextView productTextView;

        public ProductViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface ICategorySelectedListener {
        void onCategorySelected(Category category);
    }
}
