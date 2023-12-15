package hibernatepractices1;

import hibernatepractices1.model.entity.Author;
import hibernatepractices1.model.entity.Book;
import hibernatepractices1.service.BookService_jpa;
import java.util.Arrays;


public class HibernatePractices1 {

    public static void main(String[] args) throws Exception {
        BookService_jpa jpaService = new BookService_jpa();
        Book book1 = new Book("librito 1");
        Book book2 = new Book("librito 2");
        Book book3 = new Book("librito 3");
        
        Author auth = new Author();
        auth.setName("auth1");
        
        auth.setBooks(Arrays.asList(book1, book2, book3));
        
        jpaService.saveAuth(auth);
        
        
        
    }
}
