package hibernatepractices1;

import hibernatepractices1.model.entity.oneToMany.Author;
import hibernatepractices1.model.entity.oneToMany.Book;
import hibernatepractices1.service.AuthorService;
import java.util.List;

public class HibernatePractices1 {

    public static void main(String[] args) {
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

    }

}
