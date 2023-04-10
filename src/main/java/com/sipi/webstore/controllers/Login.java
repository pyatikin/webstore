package com.sipi.webstore.controllers;

import com.sipi.webstore.models.User;
import com.sipi.webstore.services.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String checkLogin(@RequestParam("email") String email, HttpServletRequest httpServletRequest) {
        User user;
        if ((user = usersService.findUser(email)) != null){
            if(httpServletRequest.getParameter("password").equals(user.getPassword()))
                System.out.println("TRUE!!!!!");
            else
                System.out.println("FALSE!!!!!");
            return "redirect:/";
        }
        System.out.println("checking...");
        return "login";
    }

    @PostMapping("registration")
    public void checkRegistration(HttpServletRequest httpServletRequest){
        //Map<String, String[]> attributes = httpServletRequest.getParameterMap();
        //System.out.println(attributes.get("name"). + attributes.get("mail")[0] + attributes.get("phone")[0] + attributes.get("password")[0]);
        User user = new User(0, httpServletRequest.getParameter("name"), httpServletRequest.getParameter("email"), httpServletRequest.getParameter("phone"), httpServletRequest.getParameter("password"));
        usersService.save(user);
        System.out.println("adding...");
    }
}
