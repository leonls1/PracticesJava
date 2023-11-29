/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolist.model.entity.taskStatePattern;

import todolist.model.entity.Task;

/**
 *
 * @author leon
 */
public class Cancelled implements State {

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
