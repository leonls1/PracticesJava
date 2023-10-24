/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBackEndReview1.controller;

import JavaBackEndReview1.dto.dtoHuman;
import JavaBackEndReview1.model.Human;
import JavaBackEndReview1.service.HumanService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author leon
 */

@RestController
@RequestMapping("Review/v1")
@CrossOrigin("http://localhost:4200/")
public class HumanController {
    @Autowired
    private HumanService service;
    
    @GetMapping("/humans")
    public List<Human> getHumans(){
        return service.getAll();
    }
    
    @GetMapping("humnas/find/{id}")
    public ResponseEntity<Human> getHumanById(@PathVariable Long id){
        return service.findHuman(id);
    }
    
    @PostMapping("humans/create")
    public Human saveHuman(@RequestBody dtoHuman human){
        return service.saveHuman(human);
    }
    
    @PutMapping("humans/edit/{id}")
    public ResponseEntity<Human> editHuman(@RequestBody dtoHuman human
                                          ,@PathVariable Long id){
        return service.updateHuman(id, human);
    }
    
    @DeleteMapping("humans/delete{id}")
    public ResponseEntity<Map<String,Boolean>> deleteHuman( @PathVariable Long id){
        return service.deleteHuman(id);
    }
}
