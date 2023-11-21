/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.service;

import java.util.List;
import model.businessLogic.entity.Incident;
/**
 *
 * @author debor
 */
public interface IncidentService {
    
    public List<Incident> getAll();
    
    public Incident getById(Long id);
    
    public void create(Incident incident);
    
    public void delete(Long id);
    
    public void update(Incident incident);
}
