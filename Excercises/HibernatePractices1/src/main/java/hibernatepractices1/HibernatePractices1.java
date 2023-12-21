package hibernatepractices1;

import hibernatepractices1.model.entity.Task;
import hibernatepractices1.model.entity.TaskType;
import hibernatepractices1.service.TaskService_jpa;
import java.time.LocalDate;
import java.util.Arrays;


public class HibernatePractices1 {

    public static void main(String[] args) {
       
       //algunos ejemplos generados para poder cargar  
       Task task1 = new Task("tarea1", "comprar pan", LocalDate.now(), LocalDate.now().plusDays(7), true);
       Task task2 = new Task("tarea2", "comprar azucar", LocalDate.now(), LocalDate.now().plusDays(7), false);
       
       TaskType type1 = new TaskType("de la casa");
       

       
       type1.setTasks(Arrays.asList(task1, task2));
       
       //creando el repository
       TaskService_jpa service = new TaskService_jpa();
        
       //service.createTaskType(type1);
        TaskType typeGetted = service.getTaskTypeById(1l);
        
        System.out.println(typeGetted.getTasks().size());
        
        Task task1Getted = service.getTaskById(1L);
        Task task1Getted2 = service.getTaskById(2L);
        
        System.out.println(task1Getted.toString() + "\n" +
                task1Getted2.toString());
        
        
                
                 
       
       
    }

   
}
