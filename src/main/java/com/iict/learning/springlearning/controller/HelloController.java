package com.iict.learning.springlearning.controller;

import com.iict.learning.springlearning.model.User;
import com.iict.learning.springlearning.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HelloController {
    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String login(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error !=null){
            model.addAttribute("result", "Email or Password incorrect.\nPlease Try again");
            return "index.html";
        }
        model.addAttribute("result", null);
        model.addAttribute("userList", userService.list());
        return "index.html";
    }

    @PostMapping("/login")
    public String postLogin(Model model, @ModelAttribute User user){
        user = userService.save(user);
        if(user != null){
            model.addAttribute("result", "Registration Successful");
        }else {
            model.addAttribute("result", "Registration Failed");
        }
        model.addAttribute("userList", userService.list());
        return "index.html";
    }
}
