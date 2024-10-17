package ar.edu.utn.frc.backend.model.service;

import ar.edu.utn.frc.backend.model.entities.Language;
import ar.edu.utn.frc.backend.model.entities.Repository;
import ar.edu.utn.frc.backend.model.entities.Tag;
import ar.edu.utn.frc.backend.model.entities.User;
import ar.edu.utn.frc.backend.model.repository.RepositoryRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class RepostoryService {
    private RepositoryRepository repositoryRepository;
    private List<Repository> repositoryList;
    private LanguageService languageService;
    private TagService tagService;
    private UserService userService;

    public RepostoryService() {

        this.repositoryRepository = new RepositoryRepository();
        this.repositoryList = new ArrayList<>();
        this.languageService = new LanguageService();
        this.tagService = new TagService();
        this.userService = new UserService();
    }

    private Repository createRepository(String line){
        String[] elements = line.split("\\|");
        //REPOSITORY_ID|
        Long id = Long.valueOf(elements[0]);
        // USER_NAME|
        String userName = elements[1];
        User user = userService.getOrCreate(userName);
        // REPOSITORY_NAME|
        String repositoryName = elements[2];
        // DESCRIPTION|
        String description = elements[3];
        // LAST_UPDATE|
        LocalDateTime lastUpdate = LocalDateTime.parse(
                elements[4],
                DateTimeFormatter.ISO_DATE_TIME);
        // LANGUAGE|
        List<String> languagesNames = new ArrayList<>(Arrays.asList(elements[5].split(",")));
        Set<Language> languages = languageService.getOrCreate(languagesNames);
        // STARS|
        double stars = Double.valueOf(elements[6]);
        // TAGS|
        List<String> tagsNames = new ArrayList<>(Arrays.asList(elements[7].split(",")));
        Set<Tag> tags = tagService.getOrCreate(tagsNames);
        // URL
        String url = elements[8];

        Repository repository = new Repository(id,repositoryName, description, lastUpdate, stars, url, user, tags, languages);                               ;
        languages.forEach(lang -> lang.addRepository(repository));
        user.addRepository(repository);
        return repository;
    }

    //1)Cargar todos los datos de los repositorios en una colección, asociando cada repositorio a los objetos
    // necesarios, y teniendo en cuenta que cada uno de los objetos asociados debe existir una y solo una vez
    // en la memoria.
    public void loadRepositories(Path path){
        try {
            Files.lines(path)
                    .skip(1)
                    .map(this::createRepository)
                    .forEach(repositoryList::add);

        }catch (IOException ioe){
            System.out.println("El archivo no existe");
        }
    }

    //2)Utilizar estructuras de datos que permitan mantener el esquema de objetos en memoria de forma tal que
    // no se repitan instancias de los objetos relacionados como usuarios, lenguajes y etiquetas.


    //3)Determinar e informar la cantidad total de repositorios importados y el número total de estrellas
    // acumuladas por todos los repositorios.
    public String totalRepositoriesAndStars(){
        long totalRepositories = repositoryList.size();
        double totalStars = repositoryList.stream()
                .mapToDouble(Repository::getStars)
                .sum();

        String response = "Numero total de repositorios: %d \n total de estrellas entre toods los repositorios: %2f";
        return String.format(response, totalRepositories, totalStars);

    }


    //4)Generar un archivo de texto separado por comas con la lista de lenguajes y la cantidad de repositorios
    // que utilizan cada uno de ellos y la suma de estrellas del conjunto de repositorios que utilizan el lenguaje.

    public void generateReport(){
        try {
            FileWriter writer = new FileWriter("punto4.txt");
            String[] languagesPunto4 = languageService.repositoriesXLanguage().split(",");
            for(String lang : languagesPunto4){
                writer.append(lang);
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //5)Mostrar por pantalla la lista de usuarios ordenados alfabéticamente junto con la cantidad de repositorios
    // que tienen y el número total de estrellas que han recibido.

    //6)Cargar todos los datos montados en memoria en una base de datos utilizando JPA.
    public void saveRepositories(){
        repositoryRepository.saveAllRepositories(repositoryList);
        System.out.println("Repositorios guardados en la db");
    }
}
