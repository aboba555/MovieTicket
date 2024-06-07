package com.bookingsystem.MovieTicket.service;

import com.bookingsystem.MovieTicket.model.Movies;
import com.bookingsystem.MovieTicket.model.User;
import com.bookingsystem.MovieTicket.repository.MoviesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MoviesService {

    private MoviesRepository moviesRepository;
    public List<Movies> findAll() {
        return moviesRepository.findAll();
    }

    public void addMovie(Movies movies){
        movies = new Movies(movies.getName(),movies.getSeetsReserved(),movies.getRoom(),movies.getPrice(),movies.getPhotoUrl());
        moviesRepository.save(movies);
    }


}
