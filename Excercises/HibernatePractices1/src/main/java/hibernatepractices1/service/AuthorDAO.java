package hibernatepractices1.service;

import hibernatepractices1.model.entity.oneToMany.Author;
import jakarta.persistence.EntityManager;

public class AuthorDAO {

    private EntityManager em;

    public void create(Author aut) {
        em.persist(aut);
    }

    public void update(Author aut) {
        em.merge(aut);
    }

    public void delete(Author auth) {
        Author a = em.merge(auth);
        em.remove(a);
    }

    public Author read(Long id) {
        return em.find(Author.class, id);
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

}
