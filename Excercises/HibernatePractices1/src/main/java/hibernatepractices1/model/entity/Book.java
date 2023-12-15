package hibernatepractices1.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "Book")
@Entity
public class Book {

    public Book() {
    }
    
    
    
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;

    public Book(String name) {
        this.name = name;
    }
    
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    
}
