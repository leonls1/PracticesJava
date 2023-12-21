package com.service;

import com.model.Person;
import java.util.List;

public interface UserService {

    public List<Person> getAll();
    
    public Person getByID(Long id);
    
    public void create(Person user);
    
    public void update(Person user, Long id);
    
    public void delete(Long id);
            
            
}
