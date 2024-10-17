package pc.leon;

import pc.leon.services.RepositoryService;

import java.io.IOException;
import java.nio.file.Path;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
       Solution solution = new Solution();
        Path path = Path.of("Repositories.txt");
       solution.loadRepositroies(path);
       solution.sizeRepositories();

        System.out.println("Persistiendo los repositorios: ");
        solution.persistRepositories();

    }
}