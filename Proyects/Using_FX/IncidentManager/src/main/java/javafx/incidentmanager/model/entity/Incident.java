package javafx.incidentmanager.model.entity;

import java.time.LocalDate;
import java.util.List;



public class Incident {
    private Long id;
    
    private Service service;
    
    private List<Client> clients;
    
    private LocalDate stimatedDate;
    
    private LocalDate entryDate;
    
    private LocalDate realFinishDate;
    
    private String description;
    
    //private State state;
    
    
}
