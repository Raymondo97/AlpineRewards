package com.alpinerewards2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductViewAdapter extends RecyclerView.Adapter<ProductViewAdapter.ViewHolder>{

    // Tag string for debugging purposes
    private static final String TAG = "ProductViewAdapter";

    // Product context and ArrayList variables
    private ArrayList<Product> products;
    private final Context productContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Attributes for product to be displayed in product list item holder
        private final TextView nameView;
        private final TextView priceView;
        private final ImageView imageView;
        private final RelativeLayout productLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = (TextView) itemView.findViewById(R.id.productName);
            priceView = (TextView) itemView.findViewById(R.id.productPrice);
            imageView = (ImageView) itemView.findViewById(R.id.productImage);
            productLayout = (RelativeLayout) itemView.findViewById(R.id.productInfo);
        }

        // Getters for attributes
        public TextView getNameView() {
            return nameView;
        }

        public TextView getPriceView() {
            return priceView;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public RelativeLayout getProductLayout() {
            return productLayout;
        }
    }

    /*
    * Constructor for adapter
    * Accepts application context, and product list
     */
    public ProductViewAdapter(Context context, ArrayList<Product> productData) {
        this.products = productData;
        this.productContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Inflates product item layout viewholder to current view
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_product, viewGroup, false);

        // Returns the new viewholder
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,
                     @SuppressLint("RecyclerView") final int index) {
        // Loads product price and name to product view
        viewHolder.getNameView().setText(this.products.get(index).getName());
        viewHolder.getPriceView().setText(this.products.get(index).getRegular_price());

        // Loads product image to be displayed
        Glide.with(productContext)
                .asBitmap()
                .load(this.products.get(index).getImages())
                .into(viewHolder.imageView);

        // Set on click listener for product redirection
        viewHolder.productLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // When product clicked on, redirect to product's webpage
                Intent viewIntent = new Intent("android.intent.action.VIEW",
                                Uri.parse("https://alpineproducts.com/product/alpine-tee-shirt/"));
                productContext.startActivity(viewIntent);
            }
        });
    }

    /*
    * Returns the size of the product list
    */
    @Override
    public int getItemCount() {
        return this.products.size();
    }
}
