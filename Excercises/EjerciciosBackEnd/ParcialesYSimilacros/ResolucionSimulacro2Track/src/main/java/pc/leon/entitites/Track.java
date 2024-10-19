package pc.leon.entitites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Table(name = "tracks")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Track {

    @Id
    private Long id;

    private String name;

    private int milliSeconds;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "track_x_artist",
            joinColumns = @JoinColumn(name = "track_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private Set<Artist> artist;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "track_x_composer",
            joinColumns = @JoinColumn(name = "track_id"),
            inverseJoinColumns = @JoinColumn(name = "composer_id"))
    private Set<Composer> composer;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name ="genre_id")
    private Genre genre;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "mediaType_id")
    private MediaType mediaType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return milliSeconds == track.milliSeconds && Objects.equals(id, track.id) && Objects.equals(name, track.name) && Objects.equals(album, track.album) && Objects.equals(artist, track.artist) && Objects.equals(genre, track.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, milliSeconds, album, artist, genre);
    }

    //Los métodos de acceso a los milisegundos en la clase track debe permitir interactuar hacia afuera de clase en
    // términos de minutos, segundos y fracciones de segundo.

    public String getDuration(){
        int minutes = this.milliSeconds/60000;
        int seconds = (this.milliSeconds%60000)/1000;
        int milliseconds = (this.milliSeconds%60000)%1000;

        String response = "Duracion total: %d minutos, %d segundos, %d milisegundos";
        return String.format(response, minutes, seconds, milliseconds);

    }

    public Track(Long id, String name, int milliSeconds, Album album, Set<Artist> artist, Set<Composer> composer, Genre genre, MediaType mediaType) {
        this.id = id;
        this.name = name;
        this.milliSeconds = milliSeconds;
        this.album = album;
        this.artist = artist;
        this.composer = composer;
        this.genre = genre;
        this.mediaType = mediaType;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", milliSeconds=" + milliSeconds +
                ", album=" + album.getName() +
                ", artist=" + artist +
                ", composer=" + composer +
                ", genre=" + genre +
                ", mediaType=" + mediaType +
                '}';
    }
}
