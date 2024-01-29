package hibernatepractices1.service;

import hibernatepractices1.model.entity.Book;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BookDAO {

    private EntityManager em;

    public void create(Book book) {
        em.persist(book);
    }

    public void update(Book book) {
        em.merge(book);
    }

    public void delete(Book book) {
        Book b = em.merge(book);
        em.remove(b);
    }

    public Book get(Long id) {
        return em.find(Book.class, id);
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public List<Book> getBooksByAuth(Long idAuthor){
        return em.createQuery("SELECT b from Book b where b.author.id = :idAuthor ",
                Book.class)
                .setParameter("idAuthor", idAuthor)
                .getResultList();

    }

}
