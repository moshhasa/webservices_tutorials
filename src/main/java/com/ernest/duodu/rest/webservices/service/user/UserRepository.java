/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.duodu.rest.webservices.service.user;

import com.ernest.duodu.rest.webservices.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ernest61523
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
