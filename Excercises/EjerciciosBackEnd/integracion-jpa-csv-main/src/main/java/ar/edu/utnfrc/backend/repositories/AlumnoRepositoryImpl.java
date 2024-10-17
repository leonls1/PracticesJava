package ar.edu.utnfrc.backend.repositories;

import ar.edu.utnfrc.backend.entities.Alumno;
import ar.edu.utnfrc.backend.repositories.interfaces.AlumnoRepository;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


public class AlumnoRepositoryImpl extends RepositoryImpl<Alumno, Integer>
        implements AlumnoRepository {


    @Override
    public Alumno findByLegajo(int legajo) {
        String jpql = "SELECT a FROM Alumno a WHERE a.legajo = :legajo";
        TypedQuery<Alumno> query = this.manager.createQuery(jpql, Alumno.class)
                .setParameter("legajo", legajo);
        var lista = query.getResultList();
        if (lista.isEmpty()) {
            return null;
        }
        else {
            return lista.get(0);
        }
    }

    @Override
    public Alumno findByDocumento(String documento) {
        TypedQuery<Alumno> query = manager
                .createNamedQuery("Alumno.findByDocumentoIdentidad", Alumno.class)
                .setParameter("dni", documento);
        return query.getSingleResult();
    }

    @Override
    public Alumno findByEmail(String email) {
        TypedQuery<Alumno> query = manager
                .createNamedQuery("Alumno.findByEmail", Alumno.class)
                .setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public Integer countRecords() {
        Query query = manager.createNamedQuery("Alumno.count");
        return query.getFirstResult();
    }
}
