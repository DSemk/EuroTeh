package com.example.icoper.euroteh.ModelsFB;

/**
 * Created by dsemk on 09.01.17.
 */

public class StockListFullCardModel {
    String name;
    String gprice;
    String price;
    String info;

    public StockListFullCardModel(String name, String gprice, String price, String info) {
        this.name = name;
        this.gprice = gprice;
        this.price = price;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGprice() {
        return gprice;
    }

    public void setGprice(String gprice) {
        this.gprice = gprice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
