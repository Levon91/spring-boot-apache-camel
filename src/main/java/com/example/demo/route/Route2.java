package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by levont on 7/24/2018.
 */
@Component
public class Route2 extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("quartz2://mytimer2?cron=0 */3 * ? * *")
                .to("log:Route2")
                .to("bean:beans?method=route2Bean");
    }
}
