package com.naveed.spring.camel.demo;

import com.naveed.spring.camel.demo.config.AppConfig;
import java.util.HashMap;
import java.util.Map;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.seda.SedaEndpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws InterruptedException, Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CamelContext camelContext = context.getBean(CamelContext.class);
        //ProducerTemplate template = camelContext.createProducerTemplate();
        ConsumerTemplate consumerTemplate = context.getBean(ConsumerTemplate.class);
        ProducerTemplate template = context.getBean(ProducerTemplate.class);
        template.sendBodyAndHeader("direct:hello", "This is a test message", "foo", "20");
        template.sendBodyAndHeader("direct:hello", "This is a test message22", "foo", "20");
        //template.sendBodyAndHeader("direct:hello2", "This is a test message2", "test", "20");
        //template.sendBody("seda:end", "This is a test message 222");
        SedaEndpoint seda = (SedaEndpoint) camelContext.getEndpoint("seda:end");
        int size = seda.getExchanges().size();
        System.out.println("Size --> " + seda.getExchanges().size());
        String response = consumerTemplate.receiveBody("seda:end", String.class);
        System.out.println(">>>>> " + response);
        System.out.println("Size --> " + seda.getExchanges().size());

        template.sendBodyAndHeader("direct:ws", "This is a test message", "foo", "20");

        //Thread.sleep(10000);
        //camelContext.stop();
//http://stackoverflow.com/questions/6522074/camel-route-http4-component-dynamic-url-parameters
//        Map<String, Object> m = new HashMap<String, Object>();
//        m.put("key1", "1");
//        m.put("key2", "2");
//        template.sendBodyAndHeaders("direct:start", null, m);
    }
}
