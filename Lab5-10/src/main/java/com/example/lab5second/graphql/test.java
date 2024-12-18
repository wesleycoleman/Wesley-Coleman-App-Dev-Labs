package com.example.lab5second.graphql;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class test {

    @QueryMapping
    public String hello() {
        return "Hello, GraphQL!";
    }
}
