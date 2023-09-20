/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package JavaBackEndReview1.service;

import JavaBackEndReview1.dto.dtoHuman;
import JavaBackEndReview1.model.Human;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author leon
 */
public interface IHuman {
    
    public Human saveHuman(dtoHuman human);
    
    public List<Human> getAll();
    
    public ResponseEntity<Human> findHuman(Long id);
    
    public ResponseEntity<Human> updateHuman(Long id ,dtoHuman human);
    
    public ResponseEntity<Map<String, Boolean>> deleteHuman(Long id);
}
