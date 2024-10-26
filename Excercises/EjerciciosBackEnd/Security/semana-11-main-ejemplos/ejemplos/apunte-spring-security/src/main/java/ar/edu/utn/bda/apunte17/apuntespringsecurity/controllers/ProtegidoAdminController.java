package ar.edu.utn.bda.apunte17.apuntespringsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protegido-administradores")
public class ProtegidoAdminController {

    @GetMapping
    public String recursoAdmin(){
        return "Este recurso es solamente para administradores!";
    }

}
