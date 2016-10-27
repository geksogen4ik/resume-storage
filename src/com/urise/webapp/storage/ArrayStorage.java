package com.urise.webapp.storage;


import com.urise.webapp.model.Resume;

import java.util.List;

/**
 * Created by Sveta on 25.09.2016.
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public int getSize() {
        return 0;
    }

    protected Integer getSearchKey(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return Integer.valueOf(-1);
    }

    @Override
    public List<Resume> doCopyAll() {
        return null;
    }


    @Override
    protected void insertElement(Resume r, int index) {

        storage[size] = r;
    }

    @Override
    protected void fillDeletedElement(int index) {

        storage[index] = storage[size];
    }

    @Override
    public List<Resume> getAllSorted() {
        return null;
    }
}
