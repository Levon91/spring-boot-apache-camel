package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by levont on 7/24/2018.
 */
@Component
public class Route3 extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("quartz2://mytimer1?cron=0 */5 * ? * *")
                .to("bean:beans?method=route3Bean");
    }
}
