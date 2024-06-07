package com.bookingsystem.MovieTicket.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;


    private String role = "USER";
    public User(){
        super();
    }
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
