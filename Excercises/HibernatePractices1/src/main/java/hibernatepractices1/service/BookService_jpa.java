package hibernatepractices1.service;

import hibernatepractices1.model.entity.Author;
import hibernatepractices1.model.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BookService_jpa {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
    EntityManager em = emf.createEntityManager();

    public void create(Book book) throws Exception {
        em.getTransaction().begin();

        em.persist(book);
        em.getTransaction().commit();
    }

    public Book getById(Long id) throws Exception {
        Book b = em.find(Book.class, id);
        return b;        
    }
    
    public void delete(Book book) throws Exception{
        em.remove(book);
        
    }
    
    public void saveAuth(Author auth){
        em.persist(auth);
    }
}
