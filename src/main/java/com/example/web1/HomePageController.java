package com.example.web1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomePageController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    @ResponseBody
    public String Homepage(){
        return userService.Showuser();
    }
}
