package com.ap.portfolio.lucalagos.DTO;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class EducationDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String instituteName;
    @NotBlank
    private String instituteImg;
    @NotBlank
    private Date eduStart;
    @NotBlank
    private Date eduEnd;
    @NotBlank
    private boolean actualEdu;

    public EducationDTO(){

    }

    public EducationDTO(String title, String instituteName, String instituteImg, Date eduStart, Date eduEnd, boolean actualEdu) {
        this.title = title;
        this.instituteName = instituteName;
        this.instituteImg = instituteImg;
        this.eduStart = eduStart;
        this.eduEnd = eduEnd;
        this.actualEdu = actualEdu;
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
