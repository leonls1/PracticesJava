package pc.leon.repositories.interfaces;

import pc.leon.entitites.Track;

import java.util.List;

public interface TrackRepository {
    void create(Track track);

    void addALl(List<Track> tracks);

    Track update(Track track);

    Track getById(Long id);

    List<Track> getAll();

    Track delete(Track track);
}
