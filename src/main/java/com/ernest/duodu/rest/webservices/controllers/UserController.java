/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.duodu.rest.webservices.controllers;

import com.ernest.duodu.rest.webservices.model.user.User;
import com.ernest.duodu.rest.webservices.exception.user.UserNotFoundException;
import com.ernest.duodu.rest.webservices.service.user.UserDaoService;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author ernest61523
 */
@RestController
public class UserController {
    
    private UserDaoService userService;
    
    @Autowired
    UserController(UserDaoService userService)
    {
        this.userService = userService;
    }
    
    
    @GetMapping("users")
    public List<User> retrieveAllUsers()
    {
        return this.userService.findAll();
    }
    
    @GetMapping("users/{id}")
    public EntityModel<User> getUser(@PathVariable long id)
    {
        User user = this.userService.findOne(id);
        if (user == null)
        {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
        
        //Note Making use of hateoas to add additional links to the response
        EntityModel<User> usersModel = EntityModel.of(user);
        WebMvcLinkBuilder linkToUsers = 
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(this.getClass())
                                .retrieveAllUsers());
        
        usersModel.add(linkToUsers.withRel("all-users"));
        return usersModel;
    }
    
    @PostMapping("users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user)
    {
        User save = this.userService.save(user);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        
        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable Long id)
    {
        if(!this.userService.delete(id))
        {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
    }
    
}
