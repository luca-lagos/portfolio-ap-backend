package com.ap.portfolio.lucalagos.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con los requisitos.")
    private String name;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con los requisitos.")
    private String lastname;
    @Size(min = 1, message = "No cumple con los requisitos.")
    private String profile_img;
}
