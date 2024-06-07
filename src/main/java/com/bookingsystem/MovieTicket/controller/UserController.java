package com.bookingsystem.MovieTicket.controller;
import com.bookingsystem.MovieTicket.model.Movies;
import com.bookingsystem.MovieTicket.model.User;
import com.bookingsystem.MovieTicket.service.MoviesService;
import com.bookingsystem.MovieTicket.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {
    private UserService userService;

    private MoviesService moviesService;


    @GetMapping("/home")
    public String welcome(Model model){
        List<Movies> movies = moviesService.findAll();
        model.addAttribute("movies",movies);
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user")User user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") User user, Model model) {
        userService.addUser(user);
        return "/login";
    }
}
