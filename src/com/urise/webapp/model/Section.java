package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sveta on 19.10.2016.
 */
public class Section {

    /*PERSONAL("Личные качества"),
    OBJECTIVE("Позиция")*/

    private final List<String> texts = new ArrayList<>();

    /*

    ACHIEVEMENT("Достижения")
    QUALIFICATIONS("Квалификация")
    */

    private final List<String> levels = new ArrayList<>();

    /*
    EXPERIENCE("Опыт работы")
    EDUCATION("Образование")
    */

    private final List<Experience> experiences = new ArrayList<>();

    public Section(String texts, String levels) {
        this.texts.addAll(Arrays.asList(texts));
        this.levels.addAll(Arrays.asList(levels));
    }


    public Section(Experience experiences) {
        this.experiences.addAll(Arrays.asList(experiences));


    }

    public List<String> getTexts() {
        return texts;
    }


    public List<String> getLevels() {
        return levels;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }
}




