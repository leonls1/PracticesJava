package javafx.incidentmanager.model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;
import javafx.incidentmanager.model.entity.Client;


public class ClientImp implements ClientDao{
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("IncendetManager-unit");
    EntityManager em = emf.createEntityManager();
    
    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Client client) {
        em.persist(client);
    }

    @Override
    public void update(Client client) {
        em.merge(client);}

    @Override
    public void findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Client client) {
        Client c = em.merge(client);
        em.remove(c);}

    @Override
    public List<Client> GetAll() {
        String jpql = "SELECT c from Client c";
        Query query = em.createQuery(jpql, Client.class);
        
        List<Client> list = query.getResultList();
        
        return list;
    }

    

}
