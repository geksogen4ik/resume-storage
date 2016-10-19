package com.urise.webapp.model;

/**
 * Created by Sveta on 19.10.2016.
 */

public class Experience {
    /*
EXPERIENCE("Опыт работы"),
EDUCATION("Образование");
 */
    private String school;
    private String university;
    private String yearsEnd;
    private String courses;
    private String job;
    private String text;


    public Experience(String school, String university, String yearsEnd, String courses, String job, String text) {
        this.school = school;
        this.university = university;
        this.yearsEnd = yearsEnd;
        this.courses = courses;
        this.job = job;
        this.text = text;
    }

    public String getSchool() {
        return school;
    }

    public String getUniversity() {
        return university;
    }

    public String getYearsEnd() {
        return yearsEnd;
    }

    public String getCourses() {
        return courses;
    }

    public String getJob() {
        return job;
    }

    public String getText() {
        return text;
    }


}









