package view;

import model.entity.Task;
import model.service.TaskImp;
import model.service.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskView {
    
    public static void main(String[] args) {
        SpringApplication.run(TaskView.class, args);
       TaskService service = new TaskImp();
    
    Task newTask = new Task("Tareita", "Tarea numero 1", true); 
    service.create(newTask);
    }
    
}
