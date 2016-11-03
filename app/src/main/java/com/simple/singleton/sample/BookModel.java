package com.simple.singleton.sample;

/**
 * Created by zhangzeyan on 16/11/3.
 */

public class BookModel {

    private String name;
    private String price;
    private String author;

    public BookModel(String name, String price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
