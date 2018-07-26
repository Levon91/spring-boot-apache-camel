package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by levont on 7/24/2018.
 */
@Component
public class MyRoute2 extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file:D:/workspace/camel/output?noop=true&scheduler=quartz2&scheduler.cron=0 * * ? * *")
                .choice()
                .when()
                .simple("${file:onlyname} regex '(.*)(txt)$'")
                .to("bean:beans?method=route2Bean");
    }
}
