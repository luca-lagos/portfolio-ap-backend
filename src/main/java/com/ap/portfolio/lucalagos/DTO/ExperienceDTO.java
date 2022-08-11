package com.ap.portfolio.lucalagos.DTO;

import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExperienceDTO {
    @NotBlank
    private String jobName;
    @NotBlank
    private String jobDescription;
    @NotBlank
    private String businessName;
    @NotBlank
    private String businessImg;
    @NotBlank
    private String location;

    private String countryLocation;
    @NotBlank
    private String workTime;
    @NotBlank
    private Date workStart;
    @NotBlank
    private Date workEnd;
    @NotBlank
    private boolean actualWork;


    public ExperienceDTO(){

    }

    public ExperienceDTO(String jobName, String jobDescription, String businessName, String businessImg, String location, String countryLocation , String workTime, Date workStart, Date workEnd, boolean actualWork) {
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
