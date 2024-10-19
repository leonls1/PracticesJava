package pc.leon.services;

import pc.leon.entities.Language;
import pc.leon.entities.Repository;
import pc.leon.repository.RepositoryRepository;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositoryService {
    private List<Repository> repositories = new ArrayList<>();
    private RepositoryRepository repositoryRepository = new RepositoryRepository();


   public void cargarArchivo(URI uri) throws IOException {
       Files.lines(Paths.get(uri))
               .skip(1)
               .map(this::getRepo)
               .forEach(repositories::add);
   }

   private Repository getRepo(String linea){
       Repository repository = new Repository();

       String[] elements = linea.split("\\|");
       //REPOSITORY_ID|
       int repositoryID = Integer.parseInt(elements[0]);
       // USER_NAME|
       String username = elements[1];
       // REPOSITORY_NAME|
       String repositoryName = elements[2];
       // DESCRIPTION|
       String description = elements[3];
       // LAST_UPDATE|
       LocalDateTime lastUpdate = LocalDateTime.parse(elements[4]);
       // LANGUAGE|
       String[] langsName = elements[5].split(",");
       // STARS|
        Double stars = Double.parseDouble(elements[6]);
       // TAGS
       String[] tags = elements[7].split(",");
        //|URL
       String url = elements[8];




       return repository;

   }

   //punto 5
    public void saveAll(){
        repositoryRepository.saveAllRepos(repositories);
    }
}
