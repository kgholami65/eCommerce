package com.example.web1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomePageController {
    UserService userService;
    ItemService itemService;
    TransactionService transactionService;

    @Autowired
    public HomePageController(UserService userService, ItemService itemService, TransactionService transactionService) {
        this.userService = userService;
        this.itemService = itemService;
        this.transactionService = transactionService;
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String Homepage() {
        return "home.jsp";
    }

    @RequestMapping(value = "/edituser", method = RequestMethod.GET)
    public String showEditUser() {
        return "editUser.jsp";
    }


    @RequestMapping(value = "/edituser", method = RequestMethod.POST)
    public RedirectView EditUser(@RequestParam String password, @RequestParam String name, ModelMap model) {
        userService.EditUserByPassword(password, name);
        return new RedirectView("/home");
    }


    @RequestMapping(value = "/showuser", method = RequestMethod.GET)
    @ResponseBody
    public User ShowUser() {
        return userService.Showuser();
    }

    @RequestMapping(value = "/viewitems", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Item> ViewItems() {
        return itemService.getAllItems();
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public String showdeposit() {
        return "deposit.jsp";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public RedirectView deposit(@RequestParam double money) {
        transactionService.deposit(money);
        return new RedirectView("/home");
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Transaction> showTransactions() {
        return transactionService.getAllTransactions();
    }

    @RequestMapping(value = "/buyitems", method = RequestMethod.GET)
    public String showbuyItems() {
        return "buyitems.jsp";
    }

    @RequestMapping(value = "/buyitems", method = RequestMethod.POST)
    public RedirectView withdraw(@RequestParam long series) {
        if (itemService.ValidateItem(series)) {
            if(!transactionService.withdrawal(itemService.getItemBySeries(series)))
                return new RedirectView("/buyitems");
            return new RedirectView("/home");
        } else
            return new RedirectView("/buyitems");
    }
}
