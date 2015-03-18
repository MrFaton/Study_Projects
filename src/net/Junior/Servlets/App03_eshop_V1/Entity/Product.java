package net.Junior.Servlets.App03_eshop_V1.Entity;

/**
 * Created by root on 16.03.2015.
 */
public class Product {
    private final int id;
    private final String name;
    private final double price;

    public Product(int id, String name, double price) {
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

    public double getPrice() {
        return price;
    }
}
/*
Наш Bean Product, который характерезует наш товар, продук. Зачем нужны геттеры? Дело в том, что когда мы на
jsp делаем так "${product.name}" (это Expressive language) и он как-то разварачивает это выражение и для
того, чтобы получить значение поля "name", а оно ведь приватно, он испльзует "getName".
 */