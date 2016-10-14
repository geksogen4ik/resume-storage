package test.com.urise.webapp.storage;


import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;

import java.util.List;

/**
 * Created by Sveta on 29.09.2016.
 */
public class ArrayStorageTest extends AbstractArrayStorageTest {
    public ArrayStorageTest() {
        super(new ArrayStorage());
    }


    @Override
    protected void assertArrayEquals(Resume[] resumes, List<Resume> allSorted) {

    }

    @Override
    protected void assertArraySort(Resume resume2, Resume resume, Resume resume1) {

    }
}