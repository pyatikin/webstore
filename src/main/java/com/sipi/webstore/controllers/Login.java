package com.sipi.webstore.controllers;

import com.sipi.webstore.models.User;
import com.sipi.webstore.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {

    private final UsersService usersService;

    @Autowired
    public Login(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("login")
    public String login()
    {
        return "login";
    }
    @GetMapping("registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("login")
    public void checkLogin(){
        System.out.println("checking...");
    }

    @PostMapping("registration")
    public void checkRegistration(@RequestParam("name") String name){
        User user = new User(0, name, null, null, null);
        usersService.save(user);
        System.out.println("adding...");
    }
}
