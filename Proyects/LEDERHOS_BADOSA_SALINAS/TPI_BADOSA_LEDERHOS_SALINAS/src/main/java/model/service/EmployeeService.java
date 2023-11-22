/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.service;

import java.util.List;
import model.businessLogic.entity.Employee;


public interface EmployeeService {
    
    public List<Employee> getAll();
    
    public Employee getById(Long id);
    
    public void create(Employee employee);
    
    public void delete(Long id);
    
    public void update(Employee employee, Long id);
    
    public Employee getEmployeeWithMoreIncidentResolvedInPeriod(int days);
}
