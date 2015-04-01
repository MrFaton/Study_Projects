package net.Junior.Servlets.App07_eshop_V2.entity;

/**
 * Created by Mr_Faton on 27.03.2015.
 */
public class Product {
    private final int id;
    private final String name;
    private final String price;

    public Product(int id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
/*
наш продукт
 */