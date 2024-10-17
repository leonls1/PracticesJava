package pc.leon.Ejercicios.Educacional.repositories.interfaces;

import pc.leon.Ejercicios.Educacional.entities.Test;

public interface TestRepository extends Repository<Test, Long>{
    Test findByStudentId(Long studentId);
}
