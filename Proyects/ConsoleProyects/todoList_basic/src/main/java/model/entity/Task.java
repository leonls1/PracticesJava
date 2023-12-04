package model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import model.entity.taskStatePattern.InProgress;
import model.entity.taskStatePattern.State;

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
    
    private boolean important;

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "id")
    private TaskType Type;

    private State state;

    public Task(String name, String description, boolean important, TaskType Type) {
        this.name = name;
        this.description = description;
        this.important = important;
        this.Type = Type;
        state = new InProgress();
    }

    public Task(String name, String description, boolean important) {
        this.name = name;
        this.description = description;
        this.important = important;
        state = new InProgress();
    }
    
    
    
    public void toCancelled(){
        state.toCancelled(this);
    }
    
    public void toCompleted(){
        state.toCompleted(this);
    }
    
    public void toInProgress(){
        state.toInProgress(this);
    }
    
    
}
