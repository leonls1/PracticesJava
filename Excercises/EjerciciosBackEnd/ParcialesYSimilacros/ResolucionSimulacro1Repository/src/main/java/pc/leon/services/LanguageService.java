package pc.leon.services;

import pc.leon.entities.Language;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LanguageService {

    Map<String, Language> mapita = new HashMap<>();

    public Set<Language> getOrCreate(String[] langsName){
        Set<Language> langs = new HashSet<>();
        for(String langName : langsName){
            langs.add(mapita.computeIfAbsent(langName,Language::new));
        }

        return langs;
    }


}
