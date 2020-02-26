package com.example.rohitmishra.headyassignment.product.presentation.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rohitmishra.headyassignment.R;
import com.example.rohitmishra.headyassignment.product.model.service.Product;
import com.example.rohitmishra.headyassignment.product.model.service.Variant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductViewAdapter extends RecyclerView.Adapter<ProductViewAdapter.ProductViewHolder> {
    private List<Product> productList;

    public ProductViewAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override

    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        Product product = productList.get(i);
        productViewHolder.titleTextView.setText(product.getName());
        String variantString = "";
        if (product.getVariants() != null) {
            for (Variant variant : product.getVariants()) {
                variantString = variantString.concat(variant.getColor()).concat(" ").concat(variant.getPrice().toString()).concat("\n");
            }
            productViewHolder.colorTextView.setVisibility(View.VISIBLE);
            productViewHolder.colorTextView.setText(variantString);
        }
    }

    @Override
    public int getItemCount() {
        return productList == null ? 0 : productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_tv)
        TextView titleTextView;

        @BindView(R.id.color_tv)
        TextView colorTextView;



        public ProductViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
