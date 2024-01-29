package javafx.incidentmanager.model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;
import javafx.incidentmanager.model.entity.Notification;

public class NotificationImp implements NotificationDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("IncendetManager-unit");
    EntityManager em = emf.createEntityManager();

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Notification notification) {
        em.persist(notification);
    }

    @Override
    public void update(Notification notification) {
        em.merge(notification);
    }

    @Override
    public void findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Notification notification) {
        Notification n = em.merge(notification);
        em.remove(n);
    }

    @Override
    public List<Notification> GetAll() {
        String jpql = "SELECT n FROM Notification n";
        Query query = em.createQuery(jpql, Notification.class);
        return query.getResultList();
    }
}
