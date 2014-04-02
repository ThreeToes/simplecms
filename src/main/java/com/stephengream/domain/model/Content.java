/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.stephengream.domain.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Stephen
 */
@Entity
@Table(name = "Account")
public class Content {
    private Long id;
    private String body, title;
    private Date created;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId(){
        return this.id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    @NotNull
    @Column(name = "body")
    public String getBody(){
        return this.body;
    }
    
    public void setBody(String body){
        this.body = body;
    }
    
    @NotNull
    @Column(name = "title")
    public String getTitle(){
        return this.title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    public Date getCreated(){
        return this.created;
    }
    
    public void setCreated(Date created){
        this.created = created;
    }
}
