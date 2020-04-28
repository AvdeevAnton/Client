package net.javaguides.springboot.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users/")
public class UserController {

    @GetMapping("login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("list")
    public String showUpdateForm() {
        return "index";
    }
    @GetMapping("test")
    public String testPage() {
        return "test";
    }
}