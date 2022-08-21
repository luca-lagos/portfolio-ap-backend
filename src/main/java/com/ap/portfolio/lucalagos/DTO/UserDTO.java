package com.ap.portfolio.lucalagos.DTO;

import javax.validation.constraints.NotBlank;

public class UserDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String profession;
    @NotBlank
    private String location;
    @NotBlank
    private String countryLocation;
    @NotBlank
    private String userProfileImg;
    @NotBlank
    private String userBackgroundImg;

    public UserDTO(){

    }

    public UserDTO(String name, String lastname, String profession, String location, String countryLocation, String userProfileImg, String userBackgroundImg) {
        this.name = name;
        this.lastname = lastname;
        this.profession = profession;
        this.location = location;
        this.countryLocation = countryLocation;
        this.userProfileImg = userProfileImg;
        this.userBackgroundImg = userBackgroundImg;
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
