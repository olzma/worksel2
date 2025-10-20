package org.example;

public class MobileOrder extends Order {
    private String mobile;

    public MobileOrder(String orderId, String product, int quantity, String mobile) {
        super(orderId, product, quantity);
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MobileOrder{" +
                "orderId='" + getOrderId() + '\'' +
                ", product='" + getProduct() + '\'' +
                ", quantity=" + getQuantity() +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
