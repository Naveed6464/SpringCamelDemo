/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.spring.camel.demo.config;

import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author nmrehman
 */
@Configuration
@ComponentScan("com.naveed.spring.camel.demo.routes")
public class AppConfig extends CamelConfiguration {

}
