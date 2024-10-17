package pc.leon.repositories;

import pc.leon.repositories.connection.DbContext;
import pc.leon.entitites.Track;
import pc.leon.repositories.interfaces.TrackRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TrackRepositoryImp implements TrackRepository {
    private DbContext context;
    private EntityManager em;

    public TrackRepositoryImp() {
        this.context = DbContext.getInstance();
        em = context.getEm();
    }

    @Override
    public void create(Track track) {
        em.getTransaction().begin();
        em.persist(track);
        em.getTransaction().commit();
    }

    @Override
    public void addALl(List<Track> tracks){
        tracks.forEach(this::create);
    }

    @Override
    public Track update(Track track) {
        em.getTransaction().begin();
        em.merge(track);

        em.getTransaction().commit();
        return track;
    }

    @Override
    public Track getById(Long id) {
        Track track = em.find(Track.class,id);
        return track;
    }

    @Override
    public List<Track> getAll() {
        TypedQuery<Track> query =em.createQuery("Select t From Track t", Track.class);
        return query.getResultList();
    }

    @Override
    public Track delete(Track track) {
        em.remove(track);
        return track;
    }
}
