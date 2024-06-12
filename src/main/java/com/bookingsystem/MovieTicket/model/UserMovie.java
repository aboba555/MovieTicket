package com.bookingsystem.MovieTicket.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_movie")
@Data
public class UserMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movies movie;

    private int numberOfTickets;

    private boolean active = false;

    public UserMovie() {}

    public UserMovie(User user, Movies movie, int numberOfTickets) {
        this.user = user;
        this.movie = movie;
        this.numberOfTickets = numberOfTickets;
    }
}