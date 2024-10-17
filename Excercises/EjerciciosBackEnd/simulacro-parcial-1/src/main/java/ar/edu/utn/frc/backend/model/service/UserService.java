package ar.edu.utn.frc.backend.model.service;

import ar.edu.utn.frc.backend.model.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> userMap;

    public UserService(){
        userMap = new HashMap<>();
    }

    public User getOrCreate(String username){
        return userMap.computeIfAbsent(username, User::new);
    }

    //5)Mostrar por pantalla la lista de usuarios ordenados alfabéticamente junto con la cantidad de repositorios
    // que tienen y el número total de estrellas que han recibido.
}
