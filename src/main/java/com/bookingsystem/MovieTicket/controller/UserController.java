package com.bookingsystem.MovieTicket.controller;
import com.bookingsystem.MovieTicket.model.Movies;
import com.bookingsystem.MovieTicket.model.Sessions;
import com.bookingsystem.MovieTicket.model.User;
import com.bookingsystem.MovieTicket.service.MoviesService;
import com.bookingsystem.MovieTicket.service.SessionsService;
import com.bookingsystem.MovieTicket.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class UserController {
    private UserService userService;

    private MoviesService moviesService;

    private SessionsService sessionsService;

    @GetMapping("/home")
    public String welcome(Model model) {
        List<Movies> movies = moviesService.findAll();
        Long userId = userService.getCurrentUserId();
        Map<Long, List<Sessions>> sessionsMap = sessionsService.findAll()
                .stream()
                .collect(Collectors.groupingBy(session -> session.getMovies().getId()));

        model.addAttribute("movies", movies);
        model.addAttribute("sessionsMap", sessionsMap);
        model.addAttribute("userId", userId);
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
