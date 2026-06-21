package com.rsa.totp.db;

import com.rsa.totp.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UserDB {

    private final Map<String, User> userDB = new HashMap<>();

    UserDB(){
        userDB.put("pradip161", new User("pradip161", "Pass@123"));
        userDB.put("sunny121", new User("sunny121", "Password@123"));
        userDB.put("ashu111", new User("ashu111", "Mypass@123"));
    }

    public void saveSecretForUserUsingUsername(String username, String secret){
        if(!userDB.containsKey(username)){
            log.info("User with username[{}] not found.", username);
            return;
        }
        User user = userDB.get(username);
        user.setSecret(secret);
        userDB.put(username, user);
    }

    public User getUserFromDBUsingUsername(String username){
        if(!userDB.containsKey(username)){
            log.info("User with username[{}] not found.", username);
            return null;
        }
        return userDB.get(username);
    }
}
