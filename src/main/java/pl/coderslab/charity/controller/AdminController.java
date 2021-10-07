package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @GetMapping("")
    public String admin(){
        return "admin/index";
    }

    @GetMapping("/institution")
    public String istitution(){

        return "admin/institution";
    }
}

