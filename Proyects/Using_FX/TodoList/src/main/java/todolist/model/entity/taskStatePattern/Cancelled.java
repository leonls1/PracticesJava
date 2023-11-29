package todolist.model.entity.taskStatePattern;

import todolist.model.entity.Task;

<<<<<<< HEAD
public class Cancelled implements State{
=======
/**
 *
 * @author leon
 */
public class Cancelled implements State {
>>>>>>> develop

    @Override
    public void toCancelled(Task task) {
    }

    @Override
    public void toInProgress(Task task) {
    }

    @Override
    public void toCompleted(Task task) {
    }

}
