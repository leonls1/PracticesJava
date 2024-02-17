package hibernatepractices1;

import hibernatepractices1.model.entity.manyToMany.Course;
import hibernatepractices1.model.entity.Author;
import hibernatepractices1.model.entity.Book;
import hibernatepractices1.model.entity.manyToMany.Student;
import hibernatepractices1.service.AuthorService;
import hibernatepractices1.service.CourseDAO;
import hibernatepractices1.service.StudentDAO;
import java.util.List;

public class HibernatePractices1 {

    public static void main(String[] args) {
        /*        
        AuthorService service = new AuthorService();
        
        Book book1 = new Book("librito de cocina");
        Book book2 = new Book("librito de java");
        
        Author auth1 = new Author("George Lucas");
        
        auth1.setBooks(List.of(book1,book2));
        book1.setAuthor(auth1);
        book2.setAuthor(auth1);
        
        service.createAuthor(auth1);
        
        Book book3 = new Book("librito de casa");
        Book book4 = new Book("librito de mysql");
        
        Author auth2 = new Author("George ");
        
        book3.setAuthor(auth2);
        book4.setAuthor(auth2);
        auth2.setBooks(List.of(book3,book4));
        
        service.createAuthor(auth2);
        
        
        Author autREcuperado = service.getAuthor(2L);
        System.out.println(autREcuperado.getBooks());

        */
        CourseDAO serviceCourse = new CourseDAO();
        StudentDAO serviceStudent = new StudentDAO();
        
        Course cou1 = new Course("matematicas");
        Course cou2 = new Course("ingles");
        Course cou3 = new Course("biologia");
        
        Student stu1 = new Student("sasha");
        Student stu2 = new Student("Leon");
        Student stu3 = new Student("Alexis");
        
        cou1.setStudents(List.of(stu1));
        cou2.setStudents(List.of(stu2));
        cou3.setStudents(List.of(stu3));
        
        stu1.setCourses(List.of(cou1,cou2,cou3));
        stu2.setCourses(List.of(cou1,cou2,cou3));
        stu3.setCourses(List.of(cou1,cou2,cou3));
        
        serviceCourse.create(cou3);
        serviceCourse.create(cou2);
        serviceCourse.create(cou1);
        
        serviceStudent.create(stu3);
        serviceStudent.create(stu2);
        serviceStudent.create(stu1);
        
        
        
        
        
    }

}
