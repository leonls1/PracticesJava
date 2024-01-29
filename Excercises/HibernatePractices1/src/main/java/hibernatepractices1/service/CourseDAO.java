package hibernatepractices1.service;

import hibernatepractices1.model.entity.manyToMany.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CourseDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
    EntityManager em = emf.createEntityManager();

    public void create(Course course) {
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
    }

    public Course read(Long id) {
        return em.find(Course.class, id);
    }

    public void delete(Course course) {
        Course c = em.merge(course);
        em.remove(c);
    }

    public void update(Course course) {
        em.merge(course);
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

}
