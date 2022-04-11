package com.virtuslab.internship;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.discount.FifteenPercentDiscount;
import com.virtuslab.internship.discount.TenPercentDiscount;
import com.virtuslab.internship.receipt.Receipt;
import com.virtuslab.internship.receipt.ReceiptGenerator;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@Path("/basket")
public class MyResource {

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Receipt getReceipt(Basket basket, @Context UriInfo uriInfo) {
        System.out.println(basket.getProducts());
        ReceiptGenerator receiptGenerator = new ReceiptGenerator();
        Receipt receipt = receiptGenerator.generate(basket);

        FifteenPercentDiscount fifteenPercentDiscount = new FifteenPercentDiscount();
        TenPercentDiscount tenPercentDiscount = new TenPercentDiscount();

        Receipt receiptAfterDiscounts = tenPercentDiscount.apply(fifteenPercentDiscount.apply(receipt));

        return receiptAfterDiscounts;
    }
}
