package ar.edu.utn.bda.apunte17.apuntespringsecurity.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protegido-mixto")
public class ProtegidoMixtoController {

    @GetMapping
    public String getUsuarios(){
        return "Este recurso puede ser consumido por Usuarios o Admins";
    }

    @PostMapping
    public String postAdmin(){
        return "POST permitido únicamente a Admins";
    }

}
