package ar.edu.utnfrc.backend.services;

import ar.edu.utnfrc.backend.entities.Opcion;
import ar.edu.utnfrc.backend.repositories.OpcionRepositoryImpl;
import ar.edu.utnfrc.backend.repositories.interfaces.OpcionRepository;
import ar.edu.utnfrc.backend.services.interfaces.OpcionService;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpcionServiceImpl extends ServiceImpl<Opcion, Integer> implements OpcionService {

    public OpcionServiceImpl() {
        repository = new OpcionRepositoryImpl();
    }

    @Override
    public void bulkInsert(URI fileCsvPath) throws IOException {
        Files.lines(Paths.get(fileCsvPath))
                .skip(1)
                .map(Opcion::new)
                .forEach(opcion -> this.repository.add(opcion));
    }

    @Override
    public List<Opcion> findAll() {
        return this.repository.findAll();
    }
}
