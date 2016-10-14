package com.urise.webapp.storage;


import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Sveta on 25.09.2016.
 */
public class SortedArrayStorage extends AbstractArrayStorage {

  /*  private static class ResumeComparator implements Comparator<Resume> {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }
    */

    private static final Comparator RESUME_COMPARATOR = (Comparator<Resume>) (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());



    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR );
    }



    @Override
    protected void insertElement(Resume r, int index) {
        int insertIdx = - index - 1;
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[insertIdx] = r;
    }

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }

}

