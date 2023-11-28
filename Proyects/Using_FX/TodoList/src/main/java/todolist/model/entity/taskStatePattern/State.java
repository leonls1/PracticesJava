/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package todolist.model.entity.taskStatePattern;

import todolist.model.entity.Task;

/**
 *
 * @author leon
 */
public interface State {

    public void toCancelled(Task task);

    public void toInProgress(Task task);

    public void toCompleted(Task task);
}
