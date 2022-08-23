package com.ap.portfolio.lucalagos.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String jobName;
    private String jobDescription;
    private String businessName;
    @Column(length = 5000)
    private String businessImg;
    private String location;

    private String countryLocation;
    private String workTime;
    private Date workStart;
    private Date workEnd;
    private boolean actualWork;


    public Experience(){

    }

    public Experience(String jobName, String jobDescription, String businessName, String businessImg, String location, String countryLocation, String workTime, Date workStart, Date workEnd, boolean actualWork) {
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.businessName = businessName;
        this.businessImg = businessImg;
        this.location = location;
        this.countryLocation = countryLocation;
        this.workTime = workTime;
        this.workStart = workStart;
        this.workEnd = workEnd;
        this.actualWork = actualWork;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessImg() {
        return businessImg;
    }

    public void setBusinessImg(String businessImg) {
        this.businessImg = businessImg;
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

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public Date getWorkStart() {
        return workStart;
    }

    public void setWorkStart(Date workStart) {
        this.workStart = workStart;
    }

    public Date getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(Date workEnd) {
        this.workEnd = workEnd;
    }

    public boolean isActualWork() {
        return actualWork;
    }
    public void setActualWork(boolean actualWork) {
        this.actualWork = actualWork;
    }
}
