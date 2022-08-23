package com.ap.portfolio.lucalagos.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String instituteName;
    @Column(length = 5000)
    private String instituteImg;
    private Date eduStart;
    private Date eduEnd;
    private boolean actualEdu;

    public Education() {

    }

    public Education(String title, String instituteName, String instituteImg, Date eduStart, Date eduEnd, boolean actualEdu) {
        this.title = title;
        this.instituteName = instituteName;
        this.instituteImg = instituteImg;
        this.eduStart = eduStart;
        this.eduEnd = eduEnd;
        this.actualEdu = actualEdu;
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

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getInstituteImg() {
        return instituteImg;
    }

    public void setInstituteImg(String instituteImg) {
        this.instituteImg = instituteImg;
    }

    public Date getEduStart() {
        return eduStart;
    }

    public void setEduStart(Date eduStart) {
        this.eduStart = eduStart;
    }

    public Date getEduEnd() {
        return eduEnd;
    }

    public void setEduEnd(Date eduEnd) {
        this.eduEnd = eduEnd;
    }

    public boolean isActualEdu() {
        return actualEdu;
    }

    public void setActualEdu(boolean actualEdu) {
        this.actualEdu = actualEdu;
    }
}
