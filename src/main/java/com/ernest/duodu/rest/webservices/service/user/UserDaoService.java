/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.duodu.rest.webservices.service.user;

import com.ernest.duodu.rest.webservices.model.user.User;
import com.ernest.duodu.rest.webservices.exception.user.UserNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ernest61523
 */
@Service
public class UserDaoService {
    
    private static final List<User> users = new ArrayList<>();
    private static int usersCount = 1;
    
    static {
        users.add(new User(usersCount, "Adam Smith", LocalDate.now()));
        users.add(new User(++usersCount, "John James", LocalDate.now()));
        users.add(new User(++usersCount, "Fish Burn", LocalDate.now()));

    }
    
    public List<User> findAll()
    {
        return users;
    }
    
    public User save(User user)
    {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
    
    /**
     *
     * @param id
     * @return
     * @throws UserNotFoundException
     */
    public User findOne(long id)
    {
       return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    public boolean delete(long id)
    {
       return users.removeIf(u -> u.getId() == id);
    }
}
