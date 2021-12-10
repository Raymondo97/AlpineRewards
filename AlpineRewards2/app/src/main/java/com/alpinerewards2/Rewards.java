package com.alpinerewards2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.icoderman.woocommerce.ApiVersionType;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.WooCommerce;
import com.icoderman.woocommerce.oauth.OAuthConfig;

import java.util.ArrayList;

public class Rewards extends AppCompatActivity {
    private static final String TAG = "RewardsActivity";
    LoginResponse loginResponse;
    TextView name;
    private final Context context = this;
    ArrayList<Product> products = new ArrayList<>();
    ProductViewAdapter adapter = new ProductViewAdapter(this, products);

//    OAuthConfig config = new OAuthConfig("http://woocommerce.com",
//            "", "");
//    WooCommerce woocommerce = new WooCommerceAPI(config, ApiVersionType.V3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards2);

        name = (TextView)findViewById(R.id.clientName);
        //Receiving data from login
        Intent intent= getIntent();
        if (intent.getExtras() != null){
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");
            name.setText(loginResponse.getUsername());
            Log.e("TAG", "====>" + loginResponse.getEmail());
            //Not sure why is not getting the firstName
            Log.e("TAG", "====>" + loginResponse.getFirst_name());
        }

        Log.d(TAG, "onCreate: Call RecyclerView Init");
        initRecyclerView();
    }

    public void initRecyclerView() {
        // Get product information

        Log.d(TAG, "initRecyclerView: Creating Product List");
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setDescription("Alpine Body Fuel Logo 60 % cotton 40% poly Fitted Large T-shirt- Light Gray");
            product.setImage(R.drawable.alpine_tshirt);
            product.setName("Alpine Logo Tee");
            product.setRegular_price("19.99");
            products.add(product);
        }
        Log.d(TAG, "initRecyclerView: Products List Length" + products.size());
//        adapter.updateList(products);

        Log.d(TAG, "initRecyclerView: Initializing Recycler");
        RecyclerView productRecycler = findViewById(R.id.productsView);
        Log.d(TAG, "initRecyclerView: Setting Adapter");
        productRecycler.setAdapter(adapter);
        Log.d(TAG, "initRecyclerView: Setting Layout");
        productRecycler.setLayoutManager(new
                GridLayoutManager(this, 2));
    }
}