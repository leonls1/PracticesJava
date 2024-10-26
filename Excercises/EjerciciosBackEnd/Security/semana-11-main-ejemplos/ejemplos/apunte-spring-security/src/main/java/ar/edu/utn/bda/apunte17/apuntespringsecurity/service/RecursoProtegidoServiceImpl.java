package ar.edu.utn.bda.apunte17.apuntespringsecurity.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class RecursoProtegidoServiceImpl
        implements RecursoProtegidoService{

    @Override
    @PreAuthorize("#idUsuario == authentication.name")
    public String buscarPorIdUsuario(String idUsuario) {
        return "Este es un recurso protegido, solamente accesible por su dueño!";
    }
}
