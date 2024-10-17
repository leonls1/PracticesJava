package ar.edu.utnfrc.backend.services;

import ar.edu.utnfrc.backend.entities.Alumno;
import ar.edu.utnfrc.backend.entities.Pregunta;
import ar.edu.utnfrc.backend.repositories.OpcionRepositoryImpl;
import ar.edu.utnfrc.backend.repositories.PreguntaRepositoryImpl;
import ar.edu.utnfrc.backend.repositories.interfaces.AlumnoRepository;
import ar.edu.utnfrc.backend.repositories.interfaces.OpcionRepository;
import ar.edu.utnfrc.backend.repositories.interfaces.PreguntaRepository;
import ar.edu.utnfrc.backend.services.interfaces.PreguntaService;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PreguntaServiceImpl extends ServiceImpl<Pregunta, Integer> implements PreguntaService {

    private final OpcionRepository opcionRepository;

    public PreguntaServiceImpl() {
        repository = new PreguntaRepositoryImpl();
        opcionRepository = new OpcionRepositoryImpl();
    }

    @Override
    public void bulkInsert(URI fileCsvPath) throws IOException {

        Files.lines(Paths.get(fileCsvPath))
                .skip(1)
                .forEach(linea -> {
                    Pregunta pregunta = crearPregunta(linea);
                    Pregunta entity = ((PreguntaRepository) repository).findByDescripcion(pregunta.getDescripcion());
                    if (entity == null)
                        this.repository.add(pregunta);
                    else {
                        pregunta.setId(entity.getId());
                        this.repository.update(pregunta);
                    }
                });
    }

    private Pregunta crearPregunta(String linea) {
        Pregunta pregunta = new Pregunta();

        String[] valores = linea.split(";");
        pregunta.setDescripcion(valores[0]);

        return pregunta;
    }

    @Override
    public List<Pregunta> findAll() {
        return List.of();
    }
}
