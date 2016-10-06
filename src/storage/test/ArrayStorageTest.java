package storage.test;

import model.Resume;
import storage.ArrayStorage;
import storage.test.AbstractArrayStorageTest;

/**
 * Created by Sveta on 29.09.2016.
 */
public class ArrayStorageTest extends AbstractArrayStorageTest {
    public ArrayStorageTest() {
        super(new ArrayStorage());
    }

    @Override
    protected void assertArraySort(Resume resume2, Resume resume, Resume resume1) {

    }
}