package com.bookingsystem.MovieTicket.controller;

import com.bookingsystem.MovieTicket.model.Movies;
import com.bookingsystem.MovieTicket.model.User;
import com.bookingsystem.MovieTicket.model.UserMovie;
import com.bookingsystem.MovieTicket.service.MoviesService;
import com.bookingsystem.MovieTicket.service.UserMovieService;
import com.bookingsystem.MovieTicket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/home")
public class MovieController {
    @Autowired
    private UserMovieService userMovieService;

    @Autowired
    private MoviesService moviesService;

    @Autowired
    private UserService userService;

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Movies movies = new Movies();
        theModel.addAttribute("movie", movies);
        return "movie-form";
    }


    @PostMapping("/save-movie")
    public String saveEmployee(@ModelAttribute("movie") Movies movies) {
        moviesService.addMovie(movies);
        return "redirect:/home";
    }

    @PostMapping("/buy-tickets")
    public String buyTicket(
            @RequestParam Long movieId,
            @RequestParam Long userId,
            @RequestParam int numberOfTickets
    ) {
        Optional<Movies> movieOptional = moviesService.findById(movieId);
        if (movieOptional.isPresent()) {
            Movies movie = movieOptional.get();
            Optional<User> userOptional = userService.findById(userId);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                UserMovie userMovie = new UserMovie(user, movie, numberOfTickets);
                userMovieService.save(userMovie);
                return "redirect:/home";
            } else {
                return "redirect:/error-page?message=User not found";
            }
        } else {
            return "redirect:/error-page?message=Movie not found";
        }
    }

}
