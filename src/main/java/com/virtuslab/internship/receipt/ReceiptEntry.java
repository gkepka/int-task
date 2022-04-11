package com.virtuslab.internship.receipt;

import com.virtuslab.internship.product.Product;

import java.math.BigDecimal;

public class ReceiptEntry {
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    public ReceiptEntry() {}

    public ReceiptEntry(
        Product product,
        int quantity,
        BigDecimal totalPrice) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public ReceiptEntry(Product product, int quantity) {
        this(product, quantity, product.price().multiply(BigDecimal.valueOf(quantity)));
    }

    public Product product() {
        return this.product;
    }

    public int quantity() {
        return this.quantity;
    }

    public BigDecimal totalPrice() {
        return this.totalPrice;
    }
}
