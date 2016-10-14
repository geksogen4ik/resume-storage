package test.com.urise.webapp.storage;


import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.SortedArrayStorage;

import java.util.List;

/**
 * Created by Sveta on 29.09.2016.
 */
public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    public SortedArrayStorageTest() {

        super(new SortedArrayStorage());
    }

    @Override
    protected void assertArrayEquals(Resume[] resumes, List<Resume> allSorted) {

    }

    @Override
    protected void assertArraySort(Resume resume2, Resume resume, Resume resume1) {

    }
}
