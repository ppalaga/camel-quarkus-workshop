package org.acme;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CoffeeOrder {

    @Id
    @GeneratedValue
    Long id;
    String userId;
    Long coffeeId;
    String blend_name;

    public CoffeeOrder() {
    }

    public CoffeeOrder(Coffee coffee) {
        this.userId = UUID.randomUUID().toString();
        this.blend_name = coffee.getBlend_name();
        this.coffeeId = coffee.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(Long coffeeId) {
        this.coffeeId = coffeeId;
    }

    public String getBlend_name() {
        return blend_name;
    }

    public void setBlend_name(String blend_name) {
        this.blend_name = blend_name;
    }
}