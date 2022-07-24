package com.example.web1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;

@Controller
public class LoginController {
    LoginService loginService;
    UserService userService;
    TransactionService transactionService;
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public LoginController(LoginService loginService,UserService userService,TransactionService transactionService){
        this.userService = userService;
        this.loginService = loginService;
        this.transactionService = transactionService;
    }


    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public String showLogin(){
        return "login.jsp";
    }


    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public RedirectView handlelogin(@RequestParam String name,@RequestParam String password){
        if(!loginService.ValidateUser(password,name)) {
            log.info("User is not valid");
            return new RedirectView("/login");
        }
        else {
            userService.setUserByPassword(password);
            log.info("an");
            transactionService.setUser(userService.getUser());
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

        if(!password.equals(password2)) {
            model.put("message", "passwords are not same");
            return new RedirectView("/adduser");
        }
        loginService.AddUser(name,password,date);
        return new RedirectView("/login");
    }
}
