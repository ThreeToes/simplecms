package com.stephengream.simplecms.web.controllers;

import com.stephengream.simplecms.domain.model.Content;
import com.stephengream.simplecms.service.ContentService;
import com.stephengream.simplecms.service.UserService;
import com.stephengream.simplecms.web.forms.ContentForm;
import java.security.Principal;
import java.util.Date;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Stephen
 */
@Controller
@RequestMapping("/content/")
public class ContentController {
    @Inject private ContentService contentService;
    @Inject private UserService userService;
    private static final String VIEW_CONTENT_NEW_CONTENT = "content/newcontent";
    private static final String VIEW_CONTENT_POST_SUCCESS = "redirect:contentok";
    private static final String VIEW_CONTENT_ALL_CONTENT = "content/allContent";
    protected static final String VIEW_CONTENT_SINGLE = "content/contentsingle";
    
    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String getNewContentForm(Model model){
        model.addAttribute("content", new ContentForm());
        return VIEW_CONTENT_NEW_CONTENT;
    }
    
    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String postNewContent(
            @ModelAttribute("content") @Valid ContentForm form,
            BindingResult result, Principal principal){
        if(!result.hasErrors()){
            final Content content = toContent(form);
            User u = (User)((Authentication) principal).getPrincipal();
            content.setAuthor(userService.loadCmsUserByName(u.getUsername()));
            contentService.create(content);
        }
        return result.hasErrors() ? VIEW_CONTENT_NEW_CONTENT : VIEW_CONTENT_POST_SUCCESS;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllContent(Model model){
        model.addAttribute("nodes", contentService.getAll());
        return VIEW_CONTENT_ALL_CONTENT;
    }
    
    @RequestMapping(value = {"/node/{nodeId}"}, method = RequestMethod.GET)
    public String getSingleContent(
            @PathVariable("nodeId") Long id,
            Model model){
        Content c = this.contentService.getContent(id);
        model.addAttribute("content", c);
        return VIEW_CONTENT_SINGLE;
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
