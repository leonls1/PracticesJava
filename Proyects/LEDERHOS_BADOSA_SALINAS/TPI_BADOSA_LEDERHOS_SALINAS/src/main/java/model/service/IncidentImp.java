/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.service;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import model.businessLogic.entity.Incident;
import model.persistence.IncidentRepository;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.stream.Collectors;

@Service
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

    
    private  boolean esAntesDeNDias(Date fecha, int dias) {
        // Obtener la fecha actual
        Calendar fechaActual = Calendar.getInstance();

        // Restar n días a la fecha actual
        fechaActual.add(Calendar.DAY_OF_MONTH, -dias);

        // Crear un objeto Calendar para la fecha dada
        Calendar fechaDada = Calendar.getInstance();
        fechaDada.setTime(fecha);

        // Comparar las fechas
        return fechaDada.before(fechaActual.getTime());
    }
    
    @Override
    public List<Incident> getIncidentsLastDays(int nDays) {
        
        List<Incident> list = getAll().stream()
                .filter(incident -> esAntesDeNDias(incident.getRealDate(), nDays) )
                .collect(Collectors.toList());
        
        
        return list;
    }
}
