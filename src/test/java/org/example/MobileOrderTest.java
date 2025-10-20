// src/test/java/org/example/MobileOrderTest.java
package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MobileOrderTest {

    @Test
    void testMobileOrderConstructorAndInheritance() {
        MobileOrder mobileOrder = new MobileOrder("123", "Book", 2, "+123");
        assertEquals("123", mobileOrder.getOrderId());
        assertEquals("Book", mobileOrder.getProduct());
        assertEquals(2, mobileOrder.getQuantity());
        assertEquals("123", mobileOrder.getMobile());
        assertTrue(mobileOrder instanceof Order);
    }

    @Test
    void testMobileSetter() {
        MobileOrder mobileOrder = new MobileOrder("123", "Book", 2, "+123");
        mobileOrder.setMobile("+999");
        assertEquals("+999".toString(), mobileOrder.getMobile());
    }

    @Test
    void testMobileOrderEquals() {
        MobileOrder mo1 = new MobileOrder("123", "Book", 2, "+123");
        MobileOrder mo2 = new MobileOrder("123", "Book", 2, "+123");
        // equals not overridden, so different instances are not equal
        assertNotEquals(mo1, mo2);
        assertEquals(mo1, mo1);
    }

    @Test
    void testMobileOrderHashCode() {
        MobileOrder mobileOrder = new MobileOrder("123", "Book", 2, "+123");
        assertEquals(mobileOrder.hashCode(), mobileOrder.hashCode());
    }

    @Test
    void testMobileOrderToString() {
        MobileOrder mobileOrder = new MobileOrder("123", "Book", 2, "+123");
        String str = mobileOrder.toString();
        assertTrue(str.contains("orderId='123'"));
        assertTrue(str.contains("product='Book'"));
        assertTrue(str.contains("quantity=2"));
        assertTrue(str.contains("mobile='+123'"));
    }
}
