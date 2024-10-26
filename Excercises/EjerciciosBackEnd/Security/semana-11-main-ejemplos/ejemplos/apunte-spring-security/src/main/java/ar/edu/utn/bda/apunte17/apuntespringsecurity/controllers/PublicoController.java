package ar.edu.utn.bda.apunte17.apuntespringsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publico")
public class PublicoController {

    @GetMapping
    public String getPublico(){
        return "Este es un recurso público!";
    }
}
