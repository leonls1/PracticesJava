package ar.edu.utnfrc.sping_service_web.repository;

import java.util.List;

public interface Service<T, ID>{
    void create(T entity);
    T findById(ID id);
    List<T> findAll();
    T update(T entity);
    void deleteById(ID id);
    boolean existsById(ID id);

}
