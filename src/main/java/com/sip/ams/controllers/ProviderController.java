package com.sip.ams.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/provider/")
public class ProviderController {
	
	@GetMapping("list")
    public String listArticles(Model model) {
        return "article/listArticles";
    }
    

}
