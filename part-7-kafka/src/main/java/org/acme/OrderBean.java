package org.acme;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class OrderBean {

    public CoffeeOrder generateOrder(Coffee coffee){
        return new CoffeeOrder(coffee);
    }
}
