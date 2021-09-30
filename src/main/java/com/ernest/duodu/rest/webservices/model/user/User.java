/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.duodu.rest.webservices.model.user;

import com.ernest.duodu.rest.webservices.model.posts.Post;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author ernest61523
 */
@Entity
public class User  {
    
    @Id
    @GeneratedValue
    private long id;
    
    @Size(min=2, message="Name should have  atleast 2 characters")
    private String name;
    
    @NotNull
    @Past
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy="author")
    private List<Post> posts = new ArrayList<>();
    
    protected User()
    {}
    
    public User(long id, String name, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

   
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + '}';
    }
    
    
    
}
