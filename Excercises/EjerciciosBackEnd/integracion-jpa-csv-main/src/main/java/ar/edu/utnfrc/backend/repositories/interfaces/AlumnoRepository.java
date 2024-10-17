package ar.edu.utnfrc.backend.repositories.interfaces;

import ar.edu.utnfrc.backend.entities.Alumno;

public interface AlumnoRepository extends Repository<Alumno, Integer> {
    Alumno findByLegajo(int legajo);
    Alumno findByDocumento(String documento);
    Alumno findByEmail(String email);
}
