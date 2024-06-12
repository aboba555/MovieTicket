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

import java.util.List;
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
    public String saveMovie(@ModelAttribute("movie") Movies movies) {
        moviesService.addMovie(movies);
        return "redirect:/home";
    }

    @PostMapping("/add-to-cart")
    public String AddToCart(
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
                return "redirect:/home/cart";
            } else {
                return "redirect:/error-page?message=User not found";
            }
        } else {
            return "redirect:/error-page?message=Movie not found";
        }
    }

    @GetMapping("/cart")
    public String cartPage(Model theModel) {
        List<UserMovie> userMovies = userMovieService.findAllByActiveFalse();
        theModel.addAttribute("userMovie", userMovies);
        return "cart";
    }

    @PostMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable Long id) {
        userMovieService.delete(id);
        return "redirect:/home/cart";
    }
    @PostMapping("/cart/removeAll")
    public String removeAllCart(){
        userMovieService.delteAll();
        return "redirect:/home/cart";
    }
    @PostMapping("/cart/buy")
    public String buyTickets(){
        userMovieService.activateTickets();
        return "redirect:/home";
    }
}