/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBackEndReview1.service;

import JavaBackEndReview1.dto.dtoHuman;
import JavaBackEndReview1.exception.ResourseNotFoundException;
import JavaBackEndReview1.model.Human;
import JavaBackEndReview1.repository.HumanRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author leon
 */
@Service
public class HumanService implements IHuman{

    @Autowired
    private HumanRepository repo;
    
    @Override
    public Human saveHuman(dtoHuman human) {
        Human h = new Human(human.getDNI(), human.getName(), human.getLastName(), human.isSex());
        return repo.save(h);
    }

    @Override
    public List<Human> getAll() {
        List<Human> list= repo.findAll();
        return list;
    }

    @Override
    public ResponseEntity<Human> findHuman(Long id) {
        Human h = repo.findById(id)//if I can found the human then return it; otherwise...
                .orElseThrow(() -> new ResourseNotFoundException("The human with the id: "+ id + " couldn't be found"));
        return ResponseEntity.ok(h);
    }

    @Override
    public ResponseEntity<Human> updateHuman(Long id, dtoHuman human) {
        Human oldHuman = repo.findById(id)
                .orElseThrow(() ->new ResourseNotFoundException("The human with the id: "+ id + " couldn't be found"));
        if(oldHuman instanceof Human){
            oldHuman.setDNI(human.getDNI());
            oldHuman.setName(human.getName());
            oldHuman.setLastName(human.getLastName());
            oldHuman.setSex(human.isSex());
            
            Human newHuman = repo.save(oldHuman);
            return ResponseEntity.ok(newHuman);
        }
        else
            return  ResponseEntity.ok(oldHuman);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteHuman(Long id) {
         Human human = repo.findById(id)
				       .orElseThrow(() -> new ResourseNotFoundException("The human with the id: "+ id + " couldn't be found"));
		
		repo.delete(human);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete",Boolean.TRUE);
		return ResponseEntity.ok(response); 
        }
    
}
