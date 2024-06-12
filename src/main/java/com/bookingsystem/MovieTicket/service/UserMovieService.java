package com.bookingsystem.MovieTicket.service;

import com.bookingsystem.MovieTicket.model.UserMovie;
import com.bookingsystem.MovieTicket.repository.UserMovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserMovieService {
    private UserMovieRepository userMovieRepository;

    public void save(UserMovie userMovie) {
        userMovieRepository.save(userMovie);
    }
    public List<UserMovie> findAllMovies(){
        return userMovieRepository.findAll();
    }
    public void delete(Long theId){
        userMovieRepository.deleteById(theId);
    }
    public void delteAll(){
        userMovieRepository.deleteAll();
    }

    public List<UserMovie> findAllByActiveFalse() {
        return userMovieRepository.findAllByActiveFalse();
    }
    public void activateTickets() {
        List<UserMovie> userMovies = userMovieRepository.findAll();
        for (UserMovie userMovie : userMovies) {
            userMovie.setActive(true);
            userMovieRepository.save(userMovie);
        }
    }
}
