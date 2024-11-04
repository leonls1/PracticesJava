package pc.leon.service;

import pc.leon.entitites.*;
import pc.leon.repositories.TrackRepositoryImp;
import pc.leon.repositories.interfaces.TrackRepository;

import javax.persistence.EntityManager;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TrackService {
    TrackRepository trackRepository;
    AlbumService albumService;
    ArtistService artistService;
    ComposerService composerService;
    GenreService genreService;
    MediaTypeService mediaTypeService;
    EntityManager em;
    List<Track> trackList;

    public TrackService(EntityManager entityManager) {
        this.em = entityManager;
        this.albumService = new AlbumService();
        this.artistService = new ArtistService();
        this.composerService = new ComposerService();
        this.genreService = new GenreService();
        this.mediaTypeService = new MediaTypeService();
        this.trackRepository = new TrackRepositoryImp();
        this.trackList = new ArrayList<>();
    }


    public void loadTracks(Path path) {
        try {
            Files.lines(path)
                    .skip(1)
                    .map(this::createTrack)
                    .forEach(trackList::add);
        } catch (IOException ioe) {
            System.out.println("EL archivo no existe en esa ubicacion:" + path.toString());
        }
    }

    //1) Cargar todos los datos de todos los tracks en la colección de tracks, asociando cada tracks a los objetos
    // necesarios y teniendo en cuenta que cada uno de los objetos asociados debe existir una y solo una vez en
    // la memoria.En este punto lo ideal sería utilizar varias estructuras de datos para mantener el esquema de
    // objetos en memoria de forma tal de no repetir instancias de los objetos relacionados como autores,
    // compositores, etc.
    //tracks generator
    private Track createTrack(String line) {
        String[] elements = line.split("\\|");

        //TRACK_ID|
        Long id = Long.valueOf(elements[0]);
        // NAME|
        String name = elements[1];
        // ALBUM|
        Album album = albumService.getOrCreate(elements[2]);
        // ARTIST_NAME|
        List<String> artistNameList = new ArrayList<>(
                Arrays.asList(elements[3].split("& ")));
        Set<Artist> artistSet = artistService.getOrCreate(artistNameList);
        // COMPOSER|
        List<String> composerNameList = new ArrayList<>(
                Arrays.asList(elements[4].split(", ")));
        Set<Composer> composerSet = composerService.getOrCreate(composerNameList);
        // MILLISECONDS|
        int milliseconds = Integer.valueOf(elements[5]);
        // GENRE|
        Genre genre = genreService.getOrCreate(elements[6]);
        // MEDIA_TYPE
        MediaType mediaType = mediaTypeService.getOrCreate(elements[7]);

        Track track = new Track(id, name, milliseconds, album, artistSet, composerSet, genre, mediaType);
        album.addTrack(track);
        return track;
    }

    //2) Determinar e informar, la cantidad de tracks importados y la duración total en horas, minutos y segundos de
    // la lista completa de tracks importada.
    public String totalTracksAndTotalDuration() {
        Long totalDuration = trackList.stream()
                .mapToLong(Track::getMilliSeconds)
                .sum();

        int totalTracks = trackList.size();
        int hours = (int) (totalDuration / 3600000);
        int minutes = (int) (totalDuration % 3600000) / 60000;
        int seconds = (int) (totalDuration % 3600000) % 60000 / 1000;

        String response = "Numero total de tracks: %d \n" +
                "Duracion total->  horas: %d, minutos: %d, segundos: %d";
        return String.format(response, totalTracks, hours, minutes, seconds);
    }

    //3) Generar un archivo de texto, separado por comas con la lista de géneros y la cantidad de tracks de cada
    // uno de los géneros.
    public void generateFileGenrePerTracks(String fileName) {
        Map<String, AtomicInteger> counter = new HashMap<>();
        try(FileWriter writer = new FileWriter(fileName)) {
            trackList.forEach(
                    track -> {
                        String genreName = track.getGenre().getName();
                        if (counter.containsKey(genreName)) {
                            counter.get(genreName).getAndIncrement();
                        } else {
                            counter.put(genreName, new AtomicInteger());
                        }
                    }
            );
            for (Map.Entry<String, AtomicInteger> entrance : counter.entrySet()) {
                writer.append(entrance.getKey())
                        .append(", ")
                        .append(entrance.getValue().toString())
                        .append("\n");
            }
        } catch (IOException e) {
            System.out.println("That is an invalid name");
            throw new RuntimeException(e);
        }
    }

    //4)Mostrar por pantalla la lista de Albumes ordenados alfabéticamente incluyendo la cantidad de tracks y la
    // duración total del álbum.
    public void getAlbumsInf(){
        List<String> albums = albumService.getAlbumsInfo();
        albums.forEach(System.out::println);
    }

    //5)Cargar todos los datos montados en memoria en una base de datos utilizando JPA
    public void saveAllTracks(){
        trackRepository.addALl(trackList);
        System.out.println("Tracks guardados correctamente");
    }




}
