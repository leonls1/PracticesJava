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
    private static int id = 1;
    private int Type;

    public Task(String name, String description, LocalDate creationDate, LocalDate endDate, boolean important, int Type) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.endDate = endDate;
        this.important = important;
        this.Type = Type;
        this.id++;
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

    public static int getId() {
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
    
    
    
}
