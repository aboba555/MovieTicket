package com.bookingsystem.MovieTicket.service;

import com.bookingsystem.MovieTicket.model.UserMovie;
import com.bookingsystem.MovieTicket.repository.UserMovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserMovieService {
    private UserMovieRepository userMovieRepository;

    public void save(UserMovie userMovie) {
        userMovieRepository.save(userMovie);
    }
}
