package storage.test;

import model.Resume;
import storage.SortedArrayStorage;

/**
 * Created by Sveta on 29.09.2016.
 */
public class SortedArrayStorageTest extends AbstractArrayStorageTest{

    public SortedArrayStorageTest() {

        super(new SortedArrayStorage());
    }


    @Override
    protected void assertArraySort(Resume resume2, Resume resume, Resume resume1) {

    }
}
