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
import todolist.model.entity.taskStatePattern.InProgress;
import todolist.model.entity.taskStatePattern.State;

@Entity

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

    public Task( String name, String description, LocalDate creationDate, boolean important, TaskType Type, State state) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.important = important;
        this.Type = Type;
        this.state = new InProgress();
    }
    
    public Task(String name, String description, LocalDate creationDate, LocalDate endDate, boolean important) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.endDate = endDate;
        this.important = important;

        state = new InProgress();
    }

    public Task(String name, String description, LocalDate creationDate, boolean important) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.important = important;
        this.state = new InProgress();
        
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public TaskType getType() {
        return Type;
    }

    public void setType(TaskType Type) {
        this.Type = Type;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    

}
