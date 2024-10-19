package pc.leon.service;

import pc.leon.entitites.Genre;

import java.util.HashMap;
import java.util.Map;

public class GenreService {
    private Map<String, Genre> genreMap;

    public GenreService(){
        this.genreMap = new HashMap<>();
    }

    public Genre getOrCreate(String genreName){
        return genreMap.computeIfAbsent(genreName, Genre::new);
    }
}
