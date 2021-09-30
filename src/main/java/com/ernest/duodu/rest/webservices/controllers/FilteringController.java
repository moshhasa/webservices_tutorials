/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.duodu.rest.webservices.controllers;

import com.ernest.duodu.rest.webservices.model.filter.DynamicFilteringBean;
import com.ernest.duodu.rest.webservices.model.filter.StaticFilteringBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ernest61523
 */
@RestController
public class FilteringController {
    
    @GetMapping("/static-filtering")
    public StaticFilteringBean retrieveStaicFilterBean()
    {
        return new StaticFilteringBean("username", "12345", "test@test.com");
    }
    
    
    @GetMapping("/dynamic-filtering")
    public MappingJacksonValue retrieveDynamicFilterBean()
    {
        DynamicFilteringBean dynamicFilteringBean = 
                new DynamicFilteringBean("username", "12345", "test@test.com");
        
        return filterFeilds(DynamicFilteringBean.FILTER_NAME, dynamicFilteringBean, "username", "email");
    }

    private MappingJacksonValue filterFeilds(String filterName, Object bean, String... fields)
    {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
        FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, filter);
        MappingJacksonValue mapping  = new MappingJacksonValue(bean);
        mapping.setFilters(filters);
        return mapping;
    }
}
