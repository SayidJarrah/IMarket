package com.dkorniichuk.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/o")  //TODO:1
public class MainController {
    public String start(Model model){
        return "index";
    }

}
