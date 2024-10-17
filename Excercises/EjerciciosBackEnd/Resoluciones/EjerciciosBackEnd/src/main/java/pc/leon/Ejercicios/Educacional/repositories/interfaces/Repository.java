package pc.leon.Ejercicios.Educacional.repositories.interfaces;

import java.util.List;

public interface Repository <K,L>{
    void add(K entity);
    void update(K entity);
    K delete(L entityId);
    K findById(L entityId, String className);
    List<K> findAll();

}
