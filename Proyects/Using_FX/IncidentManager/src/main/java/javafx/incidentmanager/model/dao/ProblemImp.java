package javafx.incidentmanager.model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;
import javafx.incidentmanager.model.entity.Problem;

public class ProblemImp implements ProblemDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("IncendetManager-unit");
    EntityManager em = emf.createEntityManager();

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Problem problem) {
        em.persist(problem);
    }

    @Override
    public void update(Problem problem) {
        em.merge(problem);
    }

    @Override
    public void findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Problem problem) {
        Problem p = em.merge(problem);
        em.remove(p);
    }

    @Override
    public List<Problem> GetAll() {
        String jpql = "SELECT p FROM Problem p";
        Query query = em.createQuery(jpql, Problem.class);
        return query.getResultList();
    }
}
