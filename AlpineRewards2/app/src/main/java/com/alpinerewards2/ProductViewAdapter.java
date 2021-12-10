package com.alpinerewards2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductViewAdapter extends RecyclerView.Adapter<ProductViewAdapter.ViewHolder>{

    private static final String TAG = "ProductViewAdapter";
    private ArrayList<Product> products;
    private final Context productContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
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

    public ProductViewAdapter(Context context, ArrayList<Product> productData) {
        this.products = productData;
        this.productContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Creating View Holder");
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_product, viewGroup, false);

        Log.d(TAG, "onCreateViewHolder: Returning View Holder");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,
                     @SuppressLint("RecyclerView") final int index) {
        Log.d(TAG, "onBindViewHolder: Binding Product Name");
        viewHolder.getNameView().setText(this.products.get(index).getName());
        Log.d(TAG, "onBindViewHolder: Binding Product Price");
        viewHolder.getPriceView().setText(this.products.get(index).getRegular_price());

        Log.d(TAG, "onBindViewHolder: Rendering Picture");
        Glide.with(productContext)
                .asBitmap()
                .load(this.products.get(index).getImage())
                .into(viewHolder.imageView);

        Log.d(TAG, "onBindViewHolder: Setting Click Listener");
        viewHolder.productLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked On:" + products.get(index));
                Toast.makeText(productContext, products.get(index).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }

    public void updateList(ArrayList<Product> givenList) {
        products.clear();
        products.addAll(givenList);
    }
}
