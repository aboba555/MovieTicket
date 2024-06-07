package com.bookingsystem.MovieTicket.repository;

import com.bookingsystem.MovieTicket.model.Movies;
import com.bookingsystem.MovieTicket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoviesRepository extends JpaRepository<Movies,Long> {
    Optional<Movies> findByName(String name);
}
