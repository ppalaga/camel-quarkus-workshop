package org.acme;

public class DeliveryBean {
    public Delivery generateOrder(CoffeeOrder order){
        return new Delivery(order);
    }
}
