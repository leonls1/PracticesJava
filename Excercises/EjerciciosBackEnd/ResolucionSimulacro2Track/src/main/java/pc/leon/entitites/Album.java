package pc.leon.entitites;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Album implements Comparable<Album> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;

    @Setter(AccessLevel.NONE)
    private Long totalMillis;

    @OneToMany(mappedBy = "album")
    private List<Track> tracks;

    public Album(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(name, album.name) && Objects.equals(totalMillis, album.totalMillis) && Objects.equals(tracks, album.tracks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalMillis, tracks);
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalMillis=" + totalMillis +
                ", tracks=" + tracks +
                '}';
    }

    //La clase Álbum debe gestionar y mantener la duración total del album y debe exponer la misma en termino de horas,
    // minutos, segundos y fracciones de segundo.

    public void setTotalMillis(){
        this.totalMillis = tracks.stream()
                .mapToLong(Track::getMilliSeconds)
                .sum();
    }

    public String getTotalDuration(){
        int hours = (int)(this.totalMillis/3600000);
        int minutes = (int)(this.totalMillis%3600000)/60000;
        int seconds = (int)(this.totalMillis%3600000)%60000/1000;
        int milliseconds = (int)(this.totalMillis%3600000)%60000%1000;

        String response = "Duracion total de el album: %d horas, %d minutos, %d segundos, %d milisegundos";
        return String.format(response,hours, minutes, seconds, milliseconds);
    }

    public void addTrack(Track track){
        this.tracks.add(track);
    }

    public String getInfo(){
        String response = "Nombre del album: %s, cantidad de tracks %d, duracion total: %d";
        return String.format(response,this.name, this.tracks.size(), this.totalMillis);
    }


    @Override
    public int compareTo(Album o) {
        return this.name.compareTo(o.name);
    }

}
