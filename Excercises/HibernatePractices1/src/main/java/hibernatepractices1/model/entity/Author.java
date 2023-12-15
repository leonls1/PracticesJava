package hibernatepractices1.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "authors")
@Data
public class Author {

    public Author() {
    }    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    @Column(name = "name", nullable = false)
    public String name;    
    
    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
    public List<Book> books;
}
