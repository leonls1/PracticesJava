
package todolist.model.entity.taskStatePattern;

import todolist.model.entity.Task;

public interface State {

    public void toCancelled(Task task);

    public void toInProgress(Task task);

    public void toCompleted(Task task);
}
