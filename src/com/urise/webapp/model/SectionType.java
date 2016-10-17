package com.urise.webapp.model;

/**
 * Created by Sveta on 17.10.2016.
 */
public enum SectionType {
    PERSONAL("Личные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    private String title;

    public String getTitle() {
        return title;
    }

    SectionType (String title){
        this.title = title;

    }
}
