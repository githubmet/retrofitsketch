package com.example.incir.retrofitsketch.model;


public class HanselandpetalStrong {
    String productId;
    String name;
    String category;
    String instructions;
    String price;
    String photo;

    @Override
    public String toString() {
        return "productId=" + productId +
                "\nname=" + name +
                "\ncategory=" + category +
                "\ninstructions=" + instructions +
                "\nprice="+price+
                "\n";
    }

    public String getPhoto() {
        return photo;
    }
}
