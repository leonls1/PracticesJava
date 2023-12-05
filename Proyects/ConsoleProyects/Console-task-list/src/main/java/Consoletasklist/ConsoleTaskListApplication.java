package Consoletasklist;

import Consoletasklist.model.entity.Task;
import Consoletasklist.model.service.TaskImp;
import Consoletasklist.model.service.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleTaskListApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsoleTaskListApplication.class, args);

        TaskService service = new TaskImp();

        Task newTask = new Task("Tareita", "Tarea numero 1", true);
        service.create(newTask);
    }

}
