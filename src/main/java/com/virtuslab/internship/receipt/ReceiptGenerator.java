package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class ReceiptGenerator {

    public Receipt generate(Basket basket) {
        List<ReceiptEntry> receiptEntries = basket.getProducts()
                .stream()
                .collect(groupingBy(Function.identity(), HashMap::new, counting()))
                .entrySet().stream()
                .map(e -> new ReceiptEntry(e.getKey(), Math.toIntExact(e.getValue()))).collect(Collectors.toList());
        return new Receipt(receiptEntries);
    }
}
