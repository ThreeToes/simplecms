package com.stephengream.simplecms.controllers;

//Spring imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Controller annotation declares this as a controller
@Controller
//RequestMapping annotation says this controller handles requests to the root of the servlet
@RequestMapping("/")
public class IndexController {
    //RequestMapping says that this method handles GET requests
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        //Sets a variable for the view
        model.addAttribute("message", "Hello World");
        //Returns a view name
	return "index";
    }
}
