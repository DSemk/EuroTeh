package com.example.icoper.euroteh.ModelsFB;

/**
 * Created by dsemk on 09.01.17.
 */

public class StockListSmallCardModel {
    String name;
    String price;
    // String imgUrl;


    public StockListSmallCardModel(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
