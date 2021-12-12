package com.alpinerewards2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.icoderman.woocommerce.EndpointBaseType;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rewards extends AppCompatActivity {
    // Tag string for debugging purposes
    private static final String TAG = "RewardsActivity";

    LoginResponse loginResponse;
    TextView name;

    // Prepares ArrayList and Adapter for product recyclerview
    Gson gson = new Gson();
    ArrayList<Product> products = new ArrayList<>();
    ProductViewAdapter adapter = new ProductViewAdapter(this, products);

    /*
    * FOR DEBUGGING PURPOSES:
    * Comments out WooCommerce API configuration for retrieving product information
    * To be fully implemented with Alpine Innovations WooCommerce API
     */

/*
    OAuthConfig config = new OAuthConfig("http://woocommerce.com",
            "", "");
    WooCommerce woocommerce = new WooCommerceAPI(config, ApiVersionType.V3);
*/

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

        // Initialize recyclerview
        initRecyclerView();
    }

    public void initRecyclerView() {
        // FOLLOWING FOR LOOP USED FOR DEVELOPMENT AND TESTING PURPOSES
        // Creates 10 placeholder products for recyclerview
        for (int i = 0; i < 10; i++) {
            Product testProduct = new Product();
            testProduct.setDescription("Alpine Body Fuel Logo 60% cotton 40% poly Fitted Large T-shirt- Light Gray");
            testProduct.setImages(R.drawable.alpine_tshirt);
            testProduct.setName("Alpine Logo Tee");
            testProduct.setRegular_price("19.99");
            products.add(testProduct);
        }

        /*
*********************** IMPORTANT!!! ***********************
        * Proper code for retrieving website product data written below
        * Commented out for testing and development purposes
        */

        /*
*********************** IMPORTANT!!! ***********************
        * Following code is designed to retrieve product data,
        * only if WooCommerce API Library doesn't work.
        * WooCommerce API method for product list is written below this block of code.
        *
        *
        * LINE FOR RETRIEVING JSON PRODUCT DATA
        * ProductList productListObject = gson.fromJson(productJson, ProductList.class);
        * ArrayList<Product> productList = productListObject.getProductList();
        * products.addAll(productList);
        */

        /*
        * Retrieves products list using WooCommerce API
        *
        * Map<String, String> params = new HashMap<>();
        * params.put("per_page","100");
        * List productsList = wooCommerce.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
        * for (Object product : productsList) {
        *     Product listItem = gson.fromJson(product.toString(), Product.class);
        *     products.add(listItem);
        * }
        */

        // Attaches recyclerview to layout, sets adapter, and sets grid layout
        RecyclerView productRecycler = findViewById(R.id.productsView);
        productRecycler.setAdapter(adapter);
        productRecycler.setLayoutManager(new
                GridLayoutManager(this, 2));
    }
}