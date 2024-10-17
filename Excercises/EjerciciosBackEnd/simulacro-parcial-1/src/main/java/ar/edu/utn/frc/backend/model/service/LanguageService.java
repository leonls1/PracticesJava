package ar.edu.utn.frc.backend.model.service;

import ar.edu.utn.frc.backend.model.entities.Language;
import ar.edu.utn.frc.backend.model.entities.Repository;

import java.util.*;

public class LanguageService {
    private Map<String, Language> languageMap;

    public LanguageService() {
        this.languageMap = new HashMap<>();
    }

    public Set<Language> getOrCreate(List<String> languageList) {
        Set<Language> languages = new HashSet<>();
        languageList.forEach(
                langName -> languages.add(
                        languageMap.computeIfAbsent(langName, Language::new)
                )
        );
        return languages;
    }

    //4)Generar un archivo de texto separado por comas con la lista de lenguajes y la cantidad de repositorios
    // que utilizan cada uno de ellos y la suma de estrellas del conjunto de repositorios que utilizan el lenguaje.
    public String repositoriesXLanguage() {
        StringBuilder sb = new StringBuilder();
        List<Language> langs = new ArrayList<>(languageMap.values());
        langs.forEach(
                language -> {
                    String langName = language.getName();
                    int totalRepositories = language.getRepositories().size();
                    double totalStars = language.getRepositories().stream()
                            .mapToDouble(Repository::getStars)
                            .sum();
                    sb.append("Language: ")
                            .append(langName)
                            .append(" el total de repositorios para:")
                            .append(totalRepositories)
                            .append(" total de estrellas entre esos repositorios:")
                            .append(totalStars)
                            .append(",\n");
                }

        );
        return sb.toString();
    }
}
