package com.ap.portfolio.lucalagos.Entity;

import javax.persistence.*;

@Entity
public class AboutMe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    private String description;

    public AboutMe(){

    }

    public AboutMe(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
