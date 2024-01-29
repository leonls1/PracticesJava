package hibernatepractices1.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Table(name = "Book")
@Entity
public class Book {

    public Book() {    }       
    
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;

    public Book(String name) {
        this.name = name;
    }
    
    @ManyToOne()
    @JoinColumn(name = "author_id")
    private Author author;

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", author=" + author + '}';
    }
    
    
    
}
