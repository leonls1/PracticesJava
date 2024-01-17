package hibernatepractices1;

import hibernatepractices1.model.entity.Task;
import hibernatepractices1.model.entity.TaskType;
import hibernatepractices1.service.TaskService_jpa;
import java.time.LocalDate;
import java.util.Arrays;


public class HibernatePractices1 {

    public static void main(String[] args) {
       
       //algunos ejemplos generados para poder cargar  
       Task task1 = new Task("tarea 6", "comprar pan", LocalDate.now(), LocalDate.now().plusDays(7), true);
       Task task2 = new Task("tarea 44", "comprar azucar", LocalDate.now(), LocalDate.now().plusDays(7), false);
       
       
       
       
       //type1.setTasks(Arrays.asList(task1, task2));      
      
       TaskService_jpa service = new TaskService_jpa();
       
       TaskType type1 = service.getTaskTypeById(1L);
       //service.createTaskType(type1);
       task1.setType(type1);
       task2.setType(type1);
       service.createTask(task2);
       service.createTask(task1);
       
      
        
                
                 
       
       
    }

   
}
