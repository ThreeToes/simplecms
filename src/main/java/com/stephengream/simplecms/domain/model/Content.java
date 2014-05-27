package com.stephengream.simplecms.domain.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Stephen
 */
@Entity
@Table(name = "Content")
public class Content {
    private Long id;
    private String body, title;
    private CmsUser author;

    @ManyToOne(
            targetEntity = com.stephengream.simplecms.domain.model.CmsUser.class,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public CmsUser getAuthor() {
        return author;
    }

    public void setAuthor(CmsUser author) {
        this.author = author;
    }
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
    @Column(name = "body", columnDefinition = "TEXT")
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
