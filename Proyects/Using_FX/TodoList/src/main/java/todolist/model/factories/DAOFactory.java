package todolist.model.factories;

import todolist.daos.TaskDAO;
import todolist.daos.TaskImp;
import todolist.daos.TaskTypeDAO;
import todolist.daos.TaskTypeImp;


public class DAOFactory {

    public static TaskDAO getTaskDao(){
        return new TaskImp();
    }
    
    public static TaskTypeDAO  getTastTypeDao(){
        return new TaskTypeImp();
    }
    
}
