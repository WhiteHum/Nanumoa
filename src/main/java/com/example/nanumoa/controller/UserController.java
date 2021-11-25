package com.example.nanumoa.controller;

import com.example.nanumoa.entity.User;
import com.example.nanumoa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }


    @GetMapping("/join")
    public String join() {
        return "/join";
    }
    @PostMapping("/join")
    public String join(User user){
        userService.save(user);
        return "login";
    }


    @GetMapping("/farmer1")
    public String farmer1() {
        return "/farmer1";
    }
    @GetMapping("/farmer2")
    public String farmer2() {
        return "/farmer2";
    }
    @GetMapping("/farmer3")
    public String farmer3() {
        return "/farmer3";
    }
    @GetMapping("/farmer/detail")
    public String farmerDetail() {
        return "/farmer_detail";
    }
    @GetMapping("/farmer/education")
    public String farmerEducation() {
        return "/farmer_education";
    }

    @GetMapping("/migrant1")
    public String migrant1() {
        return "/migrant1";
    }
    @GetMapping("/migrant2")
    public String migrant2() {
        return "/migrant2";
    }
    @GetMapping("/migrant3")
    public String migrant3() {
        return "/migrant3";
    }
    @GetMapping("/migrant/education")
    public String migrantEducation() {
        return "/migrant_education";
    }
    @GetMapping("/migrant/detail")
    public String migrantDatil() {
        return "/migrant_detail";
    }

    @GetMapping("/career/write")
    public String careerWrite() {
        return "/career_write";
    }
    @GetMapping("/about")
    public String about() {
        return "/about";
    }
    @GetMapping("/help")
    public String help() {
        return "/help";
    }
    @GetMapping("/service")
    public String service() {
        return "/service";
    }
    @GetMapping("/many/find")
    public String manyFind() {
        return "/many_find";
    }
    @GetMapping("/select/education")
    public String selectEducation() {
        return "/select_education";
    }


}
