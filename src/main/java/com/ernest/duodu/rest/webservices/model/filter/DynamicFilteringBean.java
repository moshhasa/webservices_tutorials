/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.duodu.rest.webservices.model.filter;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 *
 * @author ernest61523
 */
@JsonFilter(DynamicFilteringBean.FILTER_NAME)
public class DynamicFilteringBean {
    
    public static final String FILTER_NAME = "dynamicFilteringBeanFilter";
    
    private String username;
    private String password;
    private String email;

    public DynamicFilteringBean()
    {
    }
    
    public DynamicFilteringBean(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
