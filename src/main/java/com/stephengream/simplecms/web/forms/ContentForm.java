package com.stephengream.simplecms.web.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Stephen
 */
public class ContentForm {
    private String title, body;
    
    @NotNull
    @Size(min = 1, max = 255, message = "{newcontent.error.titlesize}")
    public String getTitle(){
        return this.title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    @NotNull
    @Size(min = 1, message = "{newcontent.error.bodysize}")
    public String getBody(){
        return this.body;
    }
    
    public void setBody(String body){
        this.body = body;
    }
}
