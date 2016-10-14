package test.com.urise.webapp.storage;


import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ListStorage;

import java.util.List;

/**
 * Created by Sveta on 14.10.2016.
 */
public class ListStorageTest extends AbstractArrayStorageTest {

    public ListStorageTest() {
        super(new ListStorage());
    }

    @Override
    protected void assertArrayEquals(Resume[] resumes, List<Resume> allSorted) {

    }

    @Override
    protected void assertArraySort(Resume resume2, Resume resume, Resume resume1) {

    }
}