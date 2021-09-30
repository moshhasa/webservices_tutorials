/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.duodu.rest.webservices.controllers;

import com.ernest.duodu.rest.webservices.model.person.PersonV1;
import com.ernest.duodu.rest.webservices.model.person.PersonV2;
import com.ernest.duodu.rest.webservices.model.person.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ernest61523
 */
@RestController
public class VersioningController {
    
    
    /***
     * 
     * uri versioning method
     */
    @GetMapping("v1/person")
    public PersonV1 personV1()
    {
        return new PersonV1("James Dodd");
    }
    
   @GetMapping("v2/person")
    public PersonV2 personV2()
    {
        return new PersonV2( new Name("James", "Dodd"));
    }
    
    /***
     * 
     * request parameter versioning method
     */
    @GetMapping(value="/person", params= "version=1")
    public PersonV1 personV1Params()
    {
        return new PersonV1("James Dodd");
    }
    
   @GetMapping(value="/person", params= "version=2")
    public PersonV2 personV2Params()
    {
        return new PersonV2( new Name("James", "Dodd"));
    }
    
    /***
     * 
     * header versioning method
     */
    @GetMapping(value="/person", headers= "X-API-VERSION=1")
    public PersonV1 personV1Header()
    {
        return new PersonV1("James Dodd");
    }
    
   @GetMapping(value="/person", headers= "X-API-VERSION=2")
    public PersonV2 personV2Header()
    {
        return new PersonV2( new Name("James", "Dodd"));
    }
    
    
    /***
     * 
     * content negotiation or accepts header or media type versioning method 
     */
    @GetMapping(value="/person", produces= "application/test.api-v1+json")
    public PersonV1 personV1Produces()
    {
        return new PersonV1("James Dodd");
    }
    
    @GetMapping(value="/person", produces= "application/test.api-v2+json")
    public PersonV2 personV2Produces()
    {
        return new PersonV2( new Name("James", "Dodd"));
    }
}
