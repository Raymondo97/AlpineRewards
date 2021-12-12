package com.alpinerewards2;

import java.util.Map;

/*
Receives image data for images from WooCommerce API
API Provides a collection of product image attributes and values
 */
public class ProductFirstImage {
    Map<String, String> images;

    // Returns the image url from the first product image's "src" value
    public String getImageUrl() {
        String imageUrl = images.get("src");
        return imageUrl;
    }
}
