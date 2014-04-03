/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.stephengream.simplecms.web.controllers;

import com.stephengream.simplecms.domain.model.Content;
import com.stephengream.simplecms.service.ContentService;
import com.stephengream.simplecms.web.forms.ContentForm;
import java.util.Date;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Stephen
 */
@Controller
@RequestMapping("/content/")
public class ContentController {
    @Inject private ContentService contentService;
    private static final String VIEW_CONTENT_NEW_CONTENT = "content/newcontent";
    private static final String VIEW_CONTENT_POST_SUCCESS = "redirect:contentok";
    private static final String VIEW_CONTENT_ALL_CONTENT = "content/allContent";
    
    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String getNewContentForm(Model model){
        model.addAttribute("content", new ContentForm());
        return VIEW_CONTENT_NEW_CONTENT;
    }
    
    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String postNewContent(
            @ModelAttribute("content") @Valid ContentForm form,
            BindingResult result){
        if(!result.hasErrors()){
            contentService.create(toContent(form));
        }
        return result.hasErrors() ? VIEW_CONTENT_NEW_CONTENT : VIEW_CONTENT_POST_SUCCESS;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllContent(Model model){
        model.addAttribute("nodes", contentService.getAll());
        return VIEW_CONTENT_ALL_CONTENT;
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setAllowedFields(new String[]{
            "title",
            "body"
        });
    }
    
    private Content toContent(ContentForm form){
        Content c = new Content();
        c.setBody(form.getBody());
        c.setTitle(form.getTitle());
        c.setCreated(new Date());
        return c;
    }
}
