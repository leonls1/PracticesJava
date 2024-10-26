package ar.edu.utn.bda.apunte17.apuntespringsecurity.controllers;


import ar.edu.utn.bda.apunte17.apuntespringsecurity.service.RecursoProtegidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("/protegido-usuarios")
public class ProtegidoUsuarioController {

    @Autowired
    private RecursoProtegidoService service;

    @GetMapping
    public String getUsuario(){
        return "Este recurso puede ser consumido por Usuarios o Admins";
    }

    @GetMapping("/{id}")
    public String getRecurso(Authentication auth,  @PathVariable("id") String id){
        log.debug("Auth Name: {}", auth.getName());
        return service.buscarPorIdUsuario(id);
    }
}
