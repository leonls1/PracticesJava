package pc.leon.service;

import lombok.Getter;
import pc.leon.entitites.Album;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumService {
    private  final Map<String, Album>  albums;

    public AlbumService() {
        albums = new HashMap<>();
    }

    public Album getOrCreate(String albumName){
        if(albums.containsKey(albumName)){
            return albums.get(albumName);
        }else{
            Album newAlbum = new Album(albumName);
            albums.put(albumName, newAlbum);
            return  newAlbum;
        }
    }

    public List<String> getAlbumsInfo(){
        albums.values().forEach(Album::setTotalMillis);
        return albums.values().stream()
                .sorted()
                .map(Album::getInfo)
                .toList();
    }
}
