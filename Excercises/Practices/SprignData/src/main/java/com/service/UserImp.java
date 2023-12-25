package com.service;

import com.model.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.UserRepository;

@Service
public class UserImp   {

    @Autowired
    UserRepository repo;

  
    public List<Person> getAll() {
        return repo.findAll();
    }

    
    public Person getByID(Long id) {
        return repo.findById(id).orElse(null);

    }

   
    public void create(Person user) {
        repo.save(user);
    }

    
    public void update(Person user, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
