package com.ap.portfolio.lucalagos.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;
    private String name;
    private String lastname;
    private String profession;
    private String location;
    private String countryLocation;
    @Column(length = 5000)
    private String userProfileImg;
    @Column(length = 5000)
    private String userBackgroundImg;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<AboutMe> aboutMeList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Experience> experienceList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Education> educationList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Skill> skillList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Project> projectList;

    public User(){

    }

    public User(String name, String lastname, String profession, String location, String countryLocation, String userProfileImg, String userBackgroundImg) {
        this.name = name;
        this.lastname = lastname;
        this.profession = profession;
        this.location = location;
        this.countryLocation = countryLocation;
        this.userProfileImg = userProfileImg;
        this.userBackgroundImg = userBackgroundImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountryLocation() {
        return countryLocation;
    }

    public void setCountryLocation(String countryLocation) {
        this.countryLocation = countryLocation;
    }

    public String getUserProfileImg() {
        return userProfileImg;
    }

    public void setUserProfileImg(String userProfileImg) {
        this.userProfileImg = userProfileImg;
    }

    public String getUserBackgroundImg() {
        return userBackgroundImg;
    }

    public void setUserBackgroundImg(String userBackgroundImg) {
        this.userBackgroundImg = userBackgroundImg;
    }
}
