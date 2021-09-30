/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ernest.duodu.rest.webservices.service;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author ernest61523
 */
@Component
public class MessageResource {

    private final MessageSource messageSource;

    @Autowired
    public MessageResource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
   public String getMessage(String key)
   {
        return getMessage(key, "");
   }
   
   public String getMessage(String key, String defaultMessage)
   {
        return messageSource.getMessage(key,
                  null, defaultMessage, LocaleContextHolder.getLocale());
   }
   
   public String getMessage(String key, String defaultMessage, Object[] params)
   {
        return getMessage(key, defaultMessage,  params,LocaleContextHolder.getLocale());
   }
   
   public String getMessage(String key, String defaultMessage, Object[] params, Locale locale)
   {
        return messageSource.getMessage(key,  params, defaultMessage, locale);
   }
   
    public String getMessage(String string, Object[] params, Locale locale) throws NoSuchMessageException
    {
        return messageSource.getMessage(string, params, string, locale);
    }

    public String getMessage(MessageSourceResolvable messageSourceResolvable, Locale locale) throws NoSuchMessageException
    {
        return messageSource.getMessage(messageSourceResolvable, locale);
    }
    
}
