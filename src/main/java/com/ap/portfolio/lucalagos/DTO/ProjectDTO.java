package com.ap.portfolio.lucalagos.DTO;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class ProjectDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String linkWeb;
    @NotBlank
    private Date projectStart;
    @NotBlank
    private Date projectEnd;
    @NotBlank
    private boolean actualProject;

    public ProjectDTO(){

    }

    public ProjectDTO(String title, String description, String linkWeb, Date projectStart, Date projectEnd, boolean actualProject) {
        this.title = title;
        this.description = description;
        this.linkWeb = linkWeb;
        this.projectStart = projectStart;
        this.projectEnd = projectEnd;
        this.actualProject = actualProject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkWeb() {
        return linkWeb;
    }

    public void setLinkWeb(String linkWeb) {
        this.linkWeb = linkWeb;
    }

    public Date getProjectStart() {
        return projectStart;
    }

    public void setProjectStart(Date projectStart) {
        this.projectStart = projectStart;
    }

    public Date getProjectEnd() {
        return projectEnd;
    }

    public void setProjectEnd(Date projectEnd) {
        this.projectEnd = projectEnd;
    }

    public boolean isActualProject() {
        return actualProject;
    }

    public void setActualProject(boolean actualProject) {
        this.actualProject = actualProject;
    }
}
