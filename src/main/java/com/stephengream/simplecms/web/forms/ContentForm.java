/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.stephengream.simplecms.web.forms;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Stephen
 */
public class ContentForm {
    private String title, body;
    
    @NotNull
    public String getTitle(){
        return this.title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    @NotNull
    public String getBody(){
        return this.body;
    }
    
    public void setBody(String body){
        this.body = body;
    }
}
