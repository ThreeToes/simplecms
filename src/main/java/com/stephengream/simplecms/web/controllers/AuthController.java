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

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Stephen
 */
@Controller
@RequestMapping(value = "/authentication/")
public class AuthController {
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error, 
            @RequestParam(value = "logout", required = false) String logout){
        //Not sure why, but CSRF protection wouldn't work without using this 
        //way of doing things
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }
 
        if (logout != null ) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        
        model.setViewName("auth/login");
        return model;
    }  
    
    @RequestMapping(value = "success", method = RequestMethod.GET)
    public String loginSuccess(ModelMap model){
        return "auth/success";
    }
}
