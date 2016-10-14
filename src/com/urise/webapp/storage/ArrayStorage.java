package com.urise.webapp.storage;


import com.urise.webapp.model.Resume;

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
    protected void insertElement(Resume r, int index) {

        storage[size] = r;
    }

    @Override
    protected void fillDeletedElement(int index) {

        storage[index] = storage[size];
    }

}
