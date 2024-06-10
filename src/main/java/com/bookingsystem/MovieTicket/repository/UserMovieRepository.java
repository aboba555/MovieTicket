package com.bookingsystem.MovieTicket.repository;

import com.bookingsystem.MovieTicket.model.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMovieRepository extends JpaRepository<UserMovie,Long> {

}
