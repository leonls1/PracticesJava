package pc.leon.services;

import pc.leon.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    Map<String, User> userMap = new HashMap<>();

    public User getOrCreate(String userName){
        return userMap.computeIfAbsent(userName, User::new);
    }

}
