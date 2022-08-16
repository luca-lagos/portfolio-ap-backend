package com.ap.portfolio.lucalagos.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String linkWeb;
    private Date projectStart;
    private Date projectEnd;
    private boolean actualProject;

    public Project(){

    }

    public Project(String title, String description, String linkWeb, Date projectStart, Date projectEnd, boolean actualProject) {
        this.title = title;
        this.description = description;
        this.linkWeb = linkWeb;
        this.projectStart = projectStart;
        this.projectEnd = projectEnd;
        this.actualProject = actualProject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
