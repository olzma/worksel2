
package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testOrderConstructor() {
        Order order = new Order("123", "Book", 2);
        assertEquals("123", order.getOrderId());
        assertEquals("Book",order.getProduct());
        assertEquals(2, order.getQuantity());

    }

    @Test
    void testOrderEquals() {
        Order order1 = new Order("123", "Book", 2);
        Order order2 = new Order("123", "Book", 2);
        // Since equals is not overridden, only same reference is equal
        assertNotEquals(order1, order2);
        assertEquals(order1, order1);
    }

    @Test
    void testOrderHashCode() {
        Order order = new Order("123", "Book", 2);
        assertEquals(order.hashCode(), order.hashCode());
    }

    @Test
    void testOrderToString() {
        Order order = new Order("123", "Book", 2);
        String str = order.toString();
        assertTrue(str.contains("orderId='123'"));
        assertTrue(str.contains("product='Book'"));
        assertTrue(str.contains("quantity=2"));
    }
}