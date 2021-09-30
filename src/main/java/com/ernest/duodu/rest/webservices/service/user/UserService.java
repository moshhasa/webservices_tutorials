/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.duodu.rest.webservices.service.user;

import com.ernest.duodu.rest.webservices.model.user.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ernest61523
 */
@Service
public class UserService {
    
    private final UserRepository repository;
    
    @Autowired
    public UserService(UserRepository repository)
    {
        this.repository = repository;
    }
    
     public List<User> findAll()
    {
        return this.repository.findAll();
    }
    
    public User save(User user)
    {
        return this.repository.save(user);
    }
    
    /**
     *
     * @param id
     * @return
     * @throws UserNotFoundException
     */
    public Optional<User> findOne(long id)
    {
      
       return this.repository.findById(id);
    }
    
    public void delete(long id)
    {
       this.repository.deleteById(id);
    }
}
