package pc.leon.Ejercicios.Educacional.repositories.interfaces;

import pc.leon.Ejercicios.Educacional.entities.Student;

public interface StudentRepository extends Repository<Student, Long>{
    Student findByEmail(String studentEmail);
}
