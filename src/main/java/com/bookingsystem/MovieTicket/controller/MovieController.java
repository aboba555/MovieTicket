package com.bookingsystem.MovieTicket.controller;

import com.bookingsystem.MovieTicket.model.Movies;
import com.bookingsystem.MovieTicket.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MovieController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Movies movies = new Movies();
        theModel.addAttribute("movie",movies);
        return "movie-form";
    }


    @PostMapping("/save-movie")
    public String saveEmployee(@ModelAttribute("movie") Movies movies){
       moviesService.addMovie(movies);
        return "redirect:/home";
    }

}
