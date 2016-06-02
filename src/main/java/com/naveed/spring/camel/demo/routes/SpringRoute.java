/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.spring.camel.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

/**
 *
 * @author nmrehman
 */
@Component
public class SpringRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:hello").to("seda:end?multipleConsumers=true").to("stream:out");

        from("direct:ws")
                //.setHeader(Exchange.HTTP_QUERY, simple("key1=${in.headers.key1}&key2=${in.headers.key2}"))
                //.setHeader("CamelHttpMethod", constant("POST"))
                .to("http4://localhost:8080/greeting")
                .unmarshal()
                .json(JsonLibrary.Jackson, Greeter.class)
                .to("stream:out");
    }
}
