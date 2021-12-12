package com.alpinerewards2;

import java.util.List;

/*
This class is responsible for receiving the image list from WooCommerce API
*/
public class ProductImages {
    private List<ProductFirstImage> images;

    // Method to be called when image url needs to retrieved from ProductFirstImage
    public String forwardImageUrl() {
        return images.get(0).getImageUrl();
    }
}
