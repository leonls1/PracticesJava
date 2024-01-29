package javafx.incidentmanager.model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;
import javafx.incidentmanager.model.entity.Service;


public class ServiceImp implements ServiceDao{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("IncendetManager-unit");
    EntityManager em = emf.createEntityManager();
    
    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Service service) {
    em.persist(service); }

    @Override
    public void update(Service service) {
    em.merge(service);}

    @Override
    public void findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Service service) {
    Service s = em.merge(service);
    em.remove(s);}

    @Override
    public List<Service> GetAll() {
    String jpql = "SELECT s FROM Service s";
    return  em.createQuery(jpql,Service.class).getResultList();}
}
