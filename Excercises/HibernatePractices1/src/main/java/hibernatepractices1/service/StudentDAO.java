package hibernatepractices1.service;

import hibernatepractices1.model.entity.manyToMany.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StudentDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
    EntityManager em = emf.createEntityManager();

    public void create(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    public Student read(Long id) {

        return em.find(Student.class, id);

    }

    public void delete(Student student) {
        Student s = em.merge(student);
        em.remove(student);

    }

    public void update(Student student) {
        em.merge(student);
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    public void createStudent(Student stu){
            em.getTransaction().begin();
            stu.getCourses().stream().forEach(c -> em.persist(em));
            em.persist(stu);
            em.getTransaction().commit();
    }
        
}
