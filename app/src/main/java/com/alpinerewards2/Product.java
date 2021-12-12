package com.alpinerewards2;

/*
This class is designed to contain the necessary information for a product to be displayed
 */
public class Product {

    // Attributes for product
    ProductImages images;
    String description;
    String name;
    String regular_price;
    String permalink;

    // This variable and method is solely for the purpose of development testing
    int testImage;
    public void setImages(int testImageLink) {
        testImage = testImageLink;
    }

    // Getters and Setters for product attributes
    public String getImages() {
        return images.forwardImageUrl();
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getRegular_price() {
        return regular_price;
    }
    public void setRegular_price(String regular_price) {
        this.regular_price = regular_price;
    }
}
