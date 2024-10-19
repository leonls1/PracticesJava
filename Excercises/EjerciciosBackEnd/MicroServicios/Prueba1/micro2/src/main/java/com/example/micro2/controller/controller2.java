package com.example.micro2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class controller2 {

    @GetMapping("/endpoint-service-2")
    public String responseFromService2(){
        return "te saludo desde el service 2, si funciono!";
    }

    @GetMapping("/endpoint-with-list")
    public ResponseEntity<?> returningAList(){
        List<String> list = List.of("elemento1, elemento2, ...., elementon");
        return ResponseEntity.ok().body(list);
    }

}
