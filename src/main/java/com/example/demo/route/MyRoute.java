package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by levont on 7/24/2018.
 */
@Component
public class MyRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:D:/workspace/camel/input")
                .to("file:D:/workspace/camel/output");
    }
}
