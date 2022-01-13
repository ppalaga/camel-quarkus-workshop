package org.acme;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http.HttpMethods;

public class MyRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        /**
         * This Camel Route simulates the external app that adds orders
         */
        from("kamelet:http-source?url={{random-coffee-api}}")
                .unmarshal().json(Coffee.class)
                .bean(OrderBean.class)
                .marshal().json()
                .to("kafka:orders");

        /**
         * This Camel Route simulates the external app that deliver orders
         */
        from("platform-http:/deliveries?httpMethodRestrict=POST")
                .log("{\"Order to deliver ${body}\"}");


        // This is the Kafka Route to create
        from("kafka:orders")
                .unmarshal().json(CoffeeOrder.class)
                .to("jpa:" + CoffeeOrder.class)
                .bean(DeliveryBean.class)
                .marshal().json()
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.POST))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .to("http:{{delivery-service-api}}");
    }
}
