package com.urise.webapp.storage;


import com.urise.webapp.model.Resume;

import java.util.List;

/**
 * Created by Sveta on 25.09.2016.
 */
public class ArrayStorage extends AbstractArrayStorage {

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
    protected void doSave(Resume r, Resume resume) {

    }

    @Override
    protected void doDelete(Resume resume) {

    }

    @Override
    protected Resume doGet(Resume resume) {
        return null;
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {

    }

    @Override
    protected boolean isExist(Resume resume) {
        return false;
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
