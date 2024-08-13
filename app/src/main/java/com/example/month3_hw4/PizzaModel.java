package com.example.month3_hw4;

import java.io.Serializable;

public class PizzaModel implements Serializable {
    String name;
    String image;
    String desc;
    String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public PizzaModel(String name, String image, String desc, String price) {
        this.name = name;
        this.image = image;
        this.desc = desc;
        this.price = price;

    }
}
