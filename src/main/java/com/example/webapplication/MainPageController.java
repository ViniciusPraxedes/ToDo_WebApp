package com.example.webapplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {
    @RequestMapping("/MainPage")
    public String helloWorldJsp(){
        return "MainPage";
    }

}


