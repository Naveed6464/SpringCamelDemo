package com.naveed.spring.camel.demo;

import com.naveed.spring.camel.demo.config.AppConfig;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws InterruptedException, Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //CamelContext camelContext = context.getBean(CamelContext.class);
        //ProducerTemplate template = camelContext.createProducerTemplate();
        ConsumerTemplate consumerTemplate = context.getBean(ConsumerTemplate.class);
        ProducerTemplate template = context.getBean(ProducerTemplate.class);
        template.sendBodyAndHeader("direct:hello", "This is a test message", "foo", "20");
        template.sendBodyAndHeader("direct:hello", "This is a test message22", "foo", "20");
        //template.sendBodyAndHeader("direct:hello2", "This is a test message2", "test", "20");
        //template.sendBody("seda:end", "This is a test message 222");
        String response = consumerTemplate.receiveBody("seda:end", String.class);
        System.out.println(">>>>> " + response);
        //Thread.sleep(10000);
        //camelContext.stop();
    }
}
