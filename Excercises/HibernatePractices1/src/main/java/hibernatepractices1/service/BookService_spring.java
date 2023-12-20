package hibernatepractices1.service;

import hibernatepractices1.model.entity.Author;
import hibernatepractices1.model.entity.Book;
import hibernatepractices1.repository.AuthorRepository;
import hibernatepractices1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService_spring {

    @Autowired
    BookRepository repoBook;
    
    @Autowired
    AuthorRepository repoAuthor;
    
    public Book getBookById(Long id){
        return repoBook.findById(id)
                .orElse(null);
    }
    
    public Author getAuthorById(Long id){
        return repoAuthor.findById(id)
                .orElse(null);
    }
}
