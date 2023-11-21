/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import model.businessLogic.entity.Incident;
import model.persistence.IncidentRepository;

/**
 *
 * @author debor
 */
public class IncidentImp implements IncidentService{
    
    @Autowired
    private IncidentRepository repo;
    
    
    @Override
    public List<Incident> getAll() {
        List<Incident> list = repo.findAll();
        return  list;
    }

    @Override
    public Incident getById(Long id) {
        return repo.findById(id).
                orElseThrow();
    }

    @Override
    public void create(Incident incident) {
        repo.save(incident);
    }

    @Override
    public void delete(Long id) {
       repo.deleteById(id);
    }

    @Override
    public void update(Incident incident, Long id) {
        //implementar lueguito
    }

    @Override
    public List<Incident> getSolvedIncidents() {
        List<Incident> solvedIncidents = repo.findAll()
                .stream()
                .filter(incident -> incident.isState())
                .collect(Collectors.toList());
        return solvedIncidents;
        
    }

    @Override
    public List<Incident> getIncidentsLastDays() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
