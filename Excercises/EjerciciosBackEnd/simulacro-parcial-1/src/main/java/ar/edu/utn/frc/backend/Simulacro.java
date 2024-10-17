package ar.edu.utn.frc.backend;

import ar.edu.utn.frc.backend.model.entities.Repository;
import ar.edu.utn.frc.backend.model.service.RepostoryService;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Simulacro {

    public static void main(String[] args) throws URISyntaxException {
        RepostoryService service = new RepostoryService();
        Path path = Paths.get(Simulacro.class.getResource("/REPOSITORIES.txt").toURI());
        service.loadRepositories(path);


        System.out.println(service.totalRepositoriesAndStars());

        //service.saveRepositories();

        service.generateReport();
    }

}
