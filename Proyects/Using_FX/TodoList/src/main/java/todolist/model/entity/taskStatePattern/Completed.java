
package todolist.model.entity.taskStatePattern;

import todolist.model.entity.Task;

public class Completed implements State{

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
