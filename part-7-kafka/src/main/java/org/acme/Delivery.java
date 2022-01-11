package org.acme;

public class Delivery {
    String name;
    CoffeeOrder order;

    public Delivery(String name) {
    }

    public Delivery(CoffeeOrder order) {
        this.order = order;
        this.name = "ZINEB";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoffeeOrder getOrder() {
        return order;
    }

    public void setOrder(CoffeeOrder order) {
        this.order = order;
    }
}
