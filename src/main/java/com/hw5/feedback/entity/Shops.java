package com.hw5.feedback.entity;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "shops")
public class Shops {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "establishment")
    private String establishment;

    @Column(name = "description")
    private String description;

    @Column(name = "response")
    private String response;

    @Column(name = "rating")
    private String rating;

    @Column(name = "creation_date")
    private LocalDate creation_date;

    public Shops() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstablishment() {
        return establishment;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDate creation_date) {
        this.creation_date = creation_date;
    }
}




