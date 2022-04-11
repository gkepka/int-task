package com.virtuslab.internship.receipt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    public List<ReceiptEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<ReceiptEntry> entries) {
        this.entries = entries;
    }

    public List<String> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<String> discounts) {
        this.discounts = discounts;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    private List<ReceiptEntry> entries;
    private List<String> discounts;
    private BigDecimal totalPrice;

    public Receipt() {}

    public Receipt(
        List<ReceiptEntry> entries,
        List<String> discounts,
        BigDecimal totalPrice) {
        this.entries = entries;
        this.discounts = discounts;
        this.totalPrice = totalPrice;
    }

    public Receipt(List<ReceiptEntry> entries) {
        this(entries,
                new ArrayList<>(),
                entries.stream()
                        .map(ReceiptEntry::totalPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );
    }

    public List<ReceiptEntry> entries() {
        return this.entries;
    }

    public List<String> discounts() {
        return this.discounts;
    }

    public BigDecimal totalPrice() {
        return this.totalPrice;
    }
}
