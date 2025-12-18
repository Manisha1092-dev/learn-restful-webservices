package com.springboot.ranga.learn_webservices.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World !!!.... ";
    }

    @GetMapping("/hello-world/{name}")
    public String helloWorld(@PathVariable ("name") String name){
        return "Hello World !!!.... "+name;
    }
}
