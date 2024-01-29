package hibernatepractices1.service;

import hibernatepractices1.model.entity.Author;
import hibernatepractices1.model.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class AuthorService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
    AuthorDAO authorDAO;
    BookDAO bookDAO;

    public AuthorService() {
        authorDAO = new AuthorDAO();
        bookDAO = new BookDAO();
    }

    public EntityManager getEntityManager() {

        EntityManager em = emf.createEntityManager();
        authorDAO.setEntityManager(em);
        bookDAO.setEntityManager(em);
        return em;
    }

    public void createAuthor(Author auth) {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        auth.getBooks().stream()
                .forEach(b -> bookDAO.create(b));
        authorDAO.create(auth);
        em.getTransaction().commit();
        em.close();
    }

    public void updateAuthor(Author auth) {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        auth.getBooks().stream()
                .forEach(b -> bookDAO.update(b));
        authorDAO.update(auth);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteAuthor(Author auth) {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        auth.getBooks().stream()
                .forEach(b -> bookDAO.delete(b));

        authorDAO.delete(auth);

        em.getTransaction().commit();
        em.close();
    }

    public Author getAuthor(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        List<Book> books = bookDAO.getBooksByAuth(id);
        Author auth = authorDAO.read(id);
        auth.setBooks(books);
        
        
        em.getTransaction().commit();
        em.close();
        
        return auth;
    }

}
