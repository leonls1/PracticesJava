package com.api.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("/hello-1")
    public String helloAdmin(){
        return "Hello Spring with KeyCloak - admin"; 
    }
    
    @GetMapping("/hello-2")
    public String helloUser(){
        return "Hello Spring with KeyCloak - user"; 
    }
}
