package pc.leon;

import pc.leon.entities.Repository;
import pc.leon.services.RepositoryService;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private RepositoryService repositoryService = new RepositoryService();
    private List<Repository> repositorios = new ArrayList<>();

    public void loadRepositroies(Path path) throws IOException {
        Files.lines(path)
                .skip(1)
                .map(Repository::new)
                .forEach(repositorios::add);
        ;
    }

    public void sizeRepositories() {
        System.out.println(repositorios.size());
    }

    public void persistRepositories() {
        if (!repositorios.isEmpty()) {
            repositorios.forEach(
                    repositoryService::create
            );
        }
    }
}
