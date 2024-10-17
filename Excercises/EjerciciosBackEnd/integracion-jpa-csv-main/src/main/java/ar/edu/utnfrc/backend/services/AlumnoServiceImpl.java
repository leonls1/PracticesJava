package ar.edu.utnfrc.backend.services;

import ar.edu.utnfrc.backend.entities.Alumno;
import ar.edu.utnfrc.backend.entities.Direccion;
import ar.edu.utnfrc.backend.repositories.AlumnoRepositoryImpl;
import ar.edu.utnfrc.backend.repositories.interfaces.AlumnoRepository;
import ar.edu.utnfrc.backend.services.interfaces.AlumnoService;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AlumnoServiceImpl extends ServiceImpl<Alumno, Integer> implements AlumnoService {

    public AlumnoServiceImpl() {
        repository = new AlumnoRepositoryImpl();
    }

    @Override
    public void bulkInsert(URI fileCsvPath) throws IOException {

        Files.lines(Paths.get(fileCsvPath))
                .skip(1)
                .map(Alumno::new)
                .forEach(alumno -> {
                    Alumno entity = ((AlumnoRepository) this.repository).findByLegajo(alumno.getLegajo());
                    if (entity == null)
                        this.repository.add(alumno);
                    else {
                        alumno.setId(entity.getId());
                        this.repository.update(alumno);
                    }
                });
    }

    @Override
    public List<Alumno> findAll() {
        return List.of();
    }
}
