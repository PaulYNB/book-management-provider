package com.paul.book.management.provider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
    @GetMapping("/")  
    public String welcome() {
        return "forward:/index.html";
    } 
}
