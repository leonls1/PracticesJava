package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class BasicController {

    @GetMapping("/{name}")
    public String sayHi(@PathVariable String name) {
        return "Hello: " + name + " !";

    }

    @GetMapping("/hi")
    public String helloWord() {
        return "Hello World";

    }
}
