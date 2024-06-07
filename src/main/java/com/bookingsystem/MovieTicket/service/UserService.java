package com.bookingsystem.MovieTicket.service;

import com.bookingsystem.MovieTicket.model.User;
import com.bookingsystem.MovieTicket.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public void addUser(User user){
        user = new User(user.getUsername(), user.getEmail(),passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
