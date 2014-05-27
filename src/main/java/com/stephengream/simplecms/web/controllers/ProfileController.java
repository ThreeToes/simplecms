/*
 * Copyright (C) 2014 Stephen
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package com.stephengream.simplecms.web.controllers;

import com.stephengream.simplecms.domain.model.CmsUser;
import com.stephengream.simplecms.domain.model.Role;
import com.stephengream.simplecms.service.UserService;
import com.stephengream.simplecms.web.forms.ContentForm;
import com.stephengream.simplecms.web.forms.UserCreationForm;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
@RequestMapping("/profile/")
public class ProfileController {
    @Inject private UserService userService;
    
    private static final String NEW_PROFILE = "profile/new";
    public static final String NEW_USER_OK = "redirect:newuserok";
    
    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String getNewUser(Model model){
        model.addAttribute("user", new UserCreationForm());
        return NEW_PROFILE;
    }
    
    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String postNewUser(@ModelAttribute("user") @Valid UserCreationForm form,
            BindingResult result){
        if(!result.hasErrors()){
            if(userService.hasUser(form.getUsername())){
                result.rejectValue("username", "newuser.error.usernameInUse");
                return NEW_PROFILE;
            }
            userService.createUser(form.getUsername(), form.getPassword(), form.getEmail());
            return NEW_USER_OK;
        }
        return NEW_PROFILE;
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setAllowedFields(new String[]{
            "username","passwordConfirm",
            "email","password"
        });
    }
    
    private static CmsUser toUser(UserCreationForm f){
        final CmsUser cmsUser = new CmsUser();
        cmsUser.setDisplayName(f.getUsername());
        cmsUser.setUsername(f.getUsername());
        cmsUser.setIsLocked(false);
        cmsUser.setEmail(f.getEmail());
        cmsUser.setUnhashedPassword(f.getPassword());
        Set<Role> roles = new HashSet<>();
        cmsUser.setRoles(roles);
        return cmsUser;
    }
}
