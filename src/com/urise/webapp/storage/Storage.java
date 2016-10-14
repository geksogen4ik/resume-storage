package com.urise.webapp.storage;


import com.urise.webapp.model.Resume;

import java.util.List;

/**
 * Created by Sveta on 25.09.2016.
 */
public interface Storage {

    void clear();

    void update(Resume r);

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    List<Resume> getAllSorted();



    int size();

}

