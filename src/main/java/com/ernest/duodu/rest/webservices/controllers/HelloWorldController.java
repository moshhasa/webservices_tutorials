/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.duodu.rest.webservices.controllers;

import com.ernest.duodu.rest.webservices.service.MessageResource;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ernest61523
 */
@RestController
public class HelloWorldController {

    private final MessageResource messageSource;
    
    @Autowired
    public HelloWorldController(MessageResource messageSource){
        this.messageSource = messageSource; 
    }

    @GetMapping("/hello-world")
    public String helloWorld()
    {
        return "Hello World";
    }
    
    @GetMapping("/hello-world-internationalised")
    public String helloWorldInternationalised(/*@RequestHeader(name="Accept-Language", required=false)Locale locale*/)
    {
        
//        return messageSource.getMessage("good.morning.message", null, "Default message", locale);
          return messageSource.getMessage("good.morning.message");

    }
    
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean()
    {
        return new HelloWorldBean("Hello World");
    }
    
         @GetMapping("/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
    

    
}
