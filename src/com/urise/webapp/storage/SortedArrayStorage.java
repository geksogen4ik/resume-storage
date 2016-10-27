package com.urise.webapp.storage;


import com.urise.webapp.model.Resume;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Sveta on 25.09.2016.
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0 , size, searchKey, ((o1, o2) -> o1.getUuid().compareTo(o2.getUuid())));
    }

    @Override
    protected void insertElement(Resume r, int index) {
        int ind = -index - 1;
        System.arraycopy(storage, ind, storage, ind+1, size - ind);
        storage[ind] = r;
    }

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }


}