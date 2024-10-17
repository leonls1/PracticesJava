package ar.edu.utnfrc.backend;

import ar.edu.utnfrc.backend.services.AlumnoServiceImpl;
import ar.edu.utnfrc.backend.services.OpcionServiceImpl;
import ar.edu.utnfrc.backend.services.PreguntaServiceImpl;
import ar.edu.utnfrc.backend.services.interfaces.AlumnoService;
import ar.edu.utnfrc.backend.services.interfaces.OpcionService;
import ar.edu.utnfrc.backend.services.interfaces.PreguntaService;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        URL folderPath = App.class.getResource("/files");

        /* Servicios */
        OpcionService opcionService = new OpcionServiceImpl();
        AlumnoService alumnoService = new AlumnoServiceImpl();
        PreguntaService preguntaService = new PreguntaServiceImpl();
        /*----------------------------*/

        List<File> csvFiles = new ArrayList<>();
        try {

            Files.walk(Paths.get(folderPath.toURI()))
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".csv"))
                    .forEach(path -> csvFiles.add(path.toFile()));

            if (!opcionService.existData()) {
                URI opcionUri = csvFiles.stream()
                        .filter(file -> file.getName().contains("opciones"))
                        .findFirst().get().toURI();
                try {
                    opcionService.bulkInsert(opcionUri);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            opcionService.findAll().forEach(System.out::println);

            List<String> names = csvFiles.stream()
                    .map(f -> f.getName().substring(0, f.getName().length() - 4))
                    .toList();

            names.forEach(fileName -> {
                URI uri;
                try {
                    uri = csvFiles.stream()
                            .filter(file -> file.getName().contains(fileName))
                            .findFirst().get().toURI();

                    switch (fileName) {
                        case "alumnos":
                            alumnoService.bulkInsert(uri);
                            break;
                        case "preguntas":
                            preguntaService.bulkInsert(uri);
                            break;
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
