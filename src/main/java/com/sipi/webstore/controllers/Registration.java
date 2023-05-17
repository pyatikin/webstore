package com.sipi.webstore.controllers;

import com.sipi.webstore.models.Users;
import com.sipi.webstore.services.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class Registration {
    private final UsersService usersService;

    public Registration(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/registration")
    public void registration(@RequestParam String login,@RequestParam String password,  @RequestParam String name)
    {
        if (!Objects.isNull(usersService.findUser(login))){
            System.out.println("Уже есть!");
        }
        else {
            usersService.save(new Users(name, login, password));
        }
    }
}
