package com.shiweile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/quick")
    public String save(){
        System.out.println("controller");
        return "good.jsp";
    }
}
