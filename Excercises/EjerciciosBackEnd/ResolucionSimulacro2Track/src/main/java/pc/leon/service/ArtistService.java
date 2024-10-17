package pc.leon.service;

import pc.leon.entitites.Album;
import pc.leon.entitites.Artist;

import java.util.*;

public class ArtistService {
    private final Map<String, Artist> artistMap;

    public ArtistService() {
        artistMap = new HashMap<>();
    }

    public Set<Artist> getOrCreate(List<String> artists) {
        Set<Artist> artistsSet = new HashSet<>();
        artists.forEach(
                artistName -> {
                    if (artistMap.containsKey(artistName)) {
                        artistsSet.add(artistMap.get(artistName));
                    } else {
                        Artist newArtist = new Artist(artistName);
                        artistMap.put(artistName, newArtist);
                        artistsSet.add(newArtist);
                    }
                });
        return artistsSet;
    }
}
