package javafx.incidentmanager.model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import javafx.incidentmanager.model.entity.Specialty;

public class SpecialtyImp implements SpecialtyDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("IncendetManager-unit");
    EntityManager em = emf.createEntityManager();

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Specialty specialty) {
        em.persist(specialty);
    }

    @Override
    public void update(Specialty specialty) {
        em.merge(specialty);
    }

    @Override
    public void findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Specialty specialty) {
        Specialty s = em.merge(specialty);
        em.remove(s);
    }

    @Override
    public List<Specialty> GetAll() {
        return em.createQuery("SELECT s FROM Specialty s", Specialty.class).getResultList();
    }
}
