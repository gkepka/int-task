package com.virtuslab.internship;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.ProductDb;
import com.virtuslab.internship.receipt.Receipt;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MyResourceTest extends JerseyTest {

    @Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(MyResource.class);
    }

    @Test
    void getReceipt() {
        //Given
        var productDb = new ProductDb();
        var cart = new Basket();
        var bread = productDb.getProduct("Bread");
        var banana = productDb.getProduct("Banana");
        var tomato = productDb.getProduct("Tomato");
        var steak = productDb.getProduct("Steak");
        var cheese = productDb.getProduct("Cheese");
        var expectedTotalPrice = bread.price().add(banana.price()).add(tomato.price())
                .add(steak.price()).add(cheese.price()).multiply(BigDecimal.valueOf(0.9));

        cart.addProduct(bread);
        cart.addProduct(banana);
        cart.addProduct(tomato);
        cart.addProduct(steak);
        cart.addProduct(cheese);

        //When
        var response = target("/basket").request().post(Entity.entity(cart, MediaType.APPLICATION_JSON));
        var receipt = (Receipt) response.readEntity(Receipt.class);

        // Then
        assertNotNull(receipt);
        assertEquals(5, receipt.entries().size());
        assertEquals(expectedTotalPrice, receipt.totalPrice());
        assertEquals(1, receipt.discounts().size());
    }
}