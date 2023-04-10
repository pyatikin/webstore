package com.sipi.webstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StartPage {
    @GetMapping("/")
    public String Hello(){
        return "start";
    }
}
