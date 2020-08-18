package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {


    @RequestMapping("toMain")
    public String toMain(){
        return "main";
    }

    @RequestMapping("/toList")
    public String toList(){
        return "list";
    }
}
