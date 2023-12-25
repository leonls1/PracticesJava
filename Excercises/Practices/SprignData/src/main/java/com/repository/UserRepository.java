package com.repository;

import com.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Person,Long>{

}
