package todolist.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;
import todolist.model.entity.taskStatePattern.InProgress;
import todolist.model.entity.taskStatePattern.State;

@Entity
@Data
@Table(name = "task")
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

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "id")
    private TaskType Type;

    private State state;

    public Task(String name, String description, LocalDate creationDate, LocalDate endDate, boolean important, TaskType Type) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.endDate = endDate;
        this.important = important;
        this.Type = Type;
        state = (State) new InProgress();
    }

    public void toCompleted() {
        state.toCompleted(this);
    }

    public void toCancelled() {
        state.toCancelled(this);
    }

    public void toInProgress() {
        state.toInProgress(this);
    }

}
