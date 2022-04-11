package com.virtuslab.internship.product;

import java.math.BigDecimal;

public class Product {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private String name;
    private Type type;
    private BigDecimal price;

    public Product() {}

    public Product(String name, Type type, BigDecimal price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String name() {
        return this.name;
    }

    public Type type() {
        return this.type;
    }

    public BigDecimal price() {
        return this.price;
    }

    public enum Type {
        DAIRY, FRUITS, VEGETABLES, MEAT, GRAINS
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}

