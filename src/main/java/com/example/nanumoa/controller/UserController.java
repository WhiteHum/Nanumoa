package com.example.nanumoa.controller;

import com.example.nanumoa.entity.UserInfoDTO;
import com.example.nanumoa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller

public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }


    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }


        @PostMapping("/user")
        public String signup(UserInfoDTO infoDto) { // 회원 추가
            userService.save(infoDto);
            return "redirect:/login";
        }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/";
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
    @GetMapping("/services")
    public String services() {
        return "/services";
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
