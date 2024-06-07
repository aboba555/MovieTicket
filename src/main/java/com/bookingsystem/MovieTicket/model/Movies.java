package com.bookingsystem.MovieTicket.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;


    private int seetsReserved;

    private int room;

    private int price;

    private String photoUrl;

    public Movies(){
        super();
    }

    public Movies(String name, int seetsReserved, int room,int price,String photoUrl) {
        this.name = name;
        this.seetsReserved = seetsReserved;
        this.room = room;
        this.price = price;
        this.photoUrl = photoUrl;
    }
}
