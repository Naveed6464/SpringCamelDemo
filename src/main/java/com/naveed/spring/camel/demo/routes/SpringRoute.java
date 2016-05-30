/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.spring.camel.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 *
 * @author nmrehman
 */
@Component
public class SpringRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:hello").to("seda:end").to("seda:end").to("stream:out");
    }

}
