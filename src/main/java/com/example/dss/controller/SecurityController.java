package com.example.dss.controller;

import com.example.dss.domain.User;
import com.example.dss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    @Autowired
    private UserService userService;

    @RequestMapping("/auth/main")
    public String mainPage(Model model) {
        final User user = userService.getUserByName("muyi-1");
        model.addAttribute("username", user.getName());
        model.addAttribute("password", user.getPassword());
        return "/main";
    }

    @RequestMapping("/auth/product")
    public String getProduct() {
        return "product";
    }

    /**
     * 登录界面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 注册界面
     *
     * @return
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 初始界面，选择登录或者注册
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }




    @RequestMapping("/login-failed")
    public String loginFailed() {
        return "error";
    }
}
