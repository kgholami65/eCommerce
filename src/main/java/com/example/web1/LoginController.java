package com.example.web1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public String showLogin(){
        return "login.jsp";
    }
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public RedirectView handlelogin(@RequestParam String name,@RequestParam String password){
        if(!loginService.ValidateUser(password,name))
            return new RedirectView("/login");
        else {
            userService.setUserByPassword(password);
            return new RedirectView("/home");
        }
    }
    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String showadduser(){
        return "adduser.jsp";
    }
    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public RedirectView handleadduser(@RequestParam String name, @RequestParam String password, @RequestParam String password2
    , @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date, ModelMap model){
        RedirectView redirectView = new RedirectView("/login");
        RedirectView redirectView1 = new RedirectView("/adduser");
        if(!password.equals(password2)) {
            model.addAttribute("message", "passwords are not same");
            //return redirectView1;
        }
        loginService.AddUser(name,password,date);
        return redirectView;
    }
}
