package com.ap.portfolio.lucalagos.DTO;

import javax.validation.constraints.NotBlank;

public class AboutMeDTO {
    @NotBlank
    private String description;

    public AboutMeDTO(){

    }

    public AboutMeDTO(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
