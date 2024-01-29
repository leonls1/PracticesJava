package hibernatepractices1.model.entity.oneToMany;
        
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Table(name = "task")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    private String description;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "end_date", nullable = true)
    private LocalDate endDate;

    private boolean important;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type")
    private TaskType type;

    public Task() {
    }

    public Task(String name, String description, LocalDate creationDate, LocalDate endDate, boolean important) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.endDate = endDate;
        this.important = important;

    }
    
}