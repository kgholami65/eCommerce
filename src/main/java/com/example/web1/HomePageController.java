package com.example.web1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomePageController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String Homepage(ModelMap model){
        model.put("name",userService.Showuser());
        return "home.jsp";
    }
    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public RedirectView EditUser(@RequestParam String password,@RequestParam String name){
        userService.EditUserByPassword(password,name);
        System.out.println(userService.Showuser());
        return new RedirectView("/home");
    }
}
