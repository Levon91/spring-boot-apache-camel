package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by levont on 7/24/2018.
 */
@Component
public class Route4 extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file:D:/workspace/camel/output?noop=true")
                .to("log:Route4")
                .to("bean:beans?method=route4Bean");
    }
}
