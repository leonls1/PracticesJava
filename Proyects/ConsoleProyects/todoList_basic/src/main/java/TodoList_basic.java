
import model.entity.Task;
import model.service.TaskImp;
import model.service.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.todolist")
public class TodoList_basic {

    public static void main(String[] args) {
        SpringApplication.run(TodoList_basic.class, args);
        TaskService service = new TaskImp();

        Task newTask = new Task("Tareita", "Tarea numero 1", true);
        service.create(newTask);
    }
}
