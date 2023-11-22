/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.service;

import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import model.businessLogic.entity.Incident;
import model.persistence.IncidentRepository;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import model.businessLogic.entity.Employee;

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
    public void update(Incident incident, Long id) {}




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


    //a. Quién fue el técnico con más incidentes resueltos en los últimos N días
    //tecnico para cada incidente,contar cuantos incidentes tiene cada tecnico
    //seleccionar el maximo

    //b. Quién fue el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días
    //igual que el anterior pero filtrando que la especialidad de cada incidente sea la ingresada por paramentro

    //c. Quién fue el técnico que más rápido resolvió los incidentes
    //consegir los incidentes por tecnico y ver dentrod de todos quien lo resolvio mas rapido
    //(EntryDate - realDate)

    @Override
    public List<Incident> getSolvedIncidents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    @Override
    public Map<Employee, Long> totalIncidentsByTech(List<Incident> incidentList, List<Employee> employeesList) {
    
        Map<Employee, Long> incident_tech =  new HashMap<>();
        for(Employee employee : employeesList ){
            Long incidentResolved = employee
                    .getSpecialities()
                    .stream()
                    .flatMap(specialty -> specialty.getIncidentes().stream())
                    .count();
            
            incident_tech.put(employee, incidentResolved);
        }
        return incident_tech;
    }    

}
