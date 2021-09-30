/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.duodu.rest.webservices.model.posts;

import com.ernest.duodu.rest.webservices.model.user.User;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ernest61523
 */
@Entity
public class Post {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private User author;
    
    private String content;
    
    public Post() {}

    public Post(User author, String content) {
        this.author = author;
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

  
    public String getContent() {
        return content;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

  
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", content=" + content + '}';
    }
}
