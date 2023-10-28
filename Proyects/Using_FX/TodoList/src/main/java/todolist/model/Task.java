/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolist.model;

import java.time.*;

public class Task {

    private String name, description;
    private LocalDate creationDate, endDate;
    private boolean important;
    private int id;
    private int Type;

    private static int currentId = 0;

    public Task(String name, String description, LocalDate creationDate, LocalDate endDate, boolean important, int Type) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.endDate = endDate;
        this.important = important;
        this.Type = Type;
        this.id = currentId;
        currentId++;
    }

    public Task(String name, String description, LocalDate creationDate, boolean important, int Type) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.important = important;
        this.id = currentId;
        currentId++;
        this.Type = Type;
    }

    public Task(String name, String description, boolean important, int Type) {
        this.name = name;
        this.description = description;
        this.important = important;
        this.id = currentId;
        currentId++;
        this.Type = Type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isImportant() {
        return important;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return Type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    @Override
    public String toString() {
        return "Task: " + name + " number: " + id + "\n"
                + "Begin of the task:" + creationDate + "\n"
                + "Date Limit: " + endDate + "\n"
                + "Type:" + Type + "\n";
    }

}
