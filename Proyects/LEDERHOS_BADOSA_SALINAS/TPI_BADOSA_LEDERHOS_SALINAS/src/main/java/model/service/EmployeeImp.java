/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.service;

import java.util.List;
import model.businessLogic.entity.Employee;
import model.businessLogic.entity.Incident;
import model.persistence.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeImp implements EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Override
    public List<Employee> getAll() {
        List<Employee> list = repo.findAll();
        return list;
    }

    @Override
    public Employee getById(Long id) {
        return repo.findById(id).
                orElseThrow();
    }

    @Override
    public void create(Employee employee) {
        repo.save(employee);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Employee newEmployee, Long id) {
        Employee oldEmployee = repo.getById(id);
        oldEmployee.setBirthDate(
                newEmployee.getBirthDate());
        oldEmployee.setEmail(
                newEmployee.getEmail());
        oldEmployee.setEmployeeType(
                newEmployee.getEmployeeType());
        oldEmployee.setEntryDate(
                newEmployee.getEntryDate());
        oldEmployee.setLastName(
                newEmployee.getLastName());
        oldEmployee.setName(
                newEmployee.getName());
        oldEmployee.setPhone(
                newEmployee.getPhone());

        repo.save(oldEmployee);
    }

    @Override
    public Employee getEmployeeWithMoreIncidentResolvedInPeriod(int days) {
        IncidentService incidentService = new IncidentImp();
        List<Incident> incidenList  = incidentService.getIncidentsLastDays(days);
        List<Employee> employeeList = //what?
        
    }

}
