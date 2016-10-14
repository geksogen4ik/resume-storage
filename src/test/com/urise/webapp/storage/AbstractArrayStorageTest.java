package test.com.urise.webapp.storage;


import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.AbstractArrayStorage;
import com.urise.webapp.storage.ArrayStorage;
import com.urise.webapp.storage.SortedArrayStorage;
import com.urise.webapp.storage.Storage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sveta on 29.09.2016.
 */
public abstract class AbstractArrayStorageTest {

    private Storage storage = new ArrayStorage();

    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_1;

    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2;

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3;

    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_4;

    static{
        RESUME_1 = new Resume(UUID_1);
        RESUME_2 = new Resume(UUID_2);
        RESUME_3 = new Resume(UUID_3);
        RESUME_4 = new Resume(UUID_4);
    }


    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    public AbstractArrayStorageTest(ArrayStorage arrayStorage) {
    }

    public AbstractArrayStorageTest(SortedArrayStorage sortedArrayStorage) {
    }


    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);

    }

    @Test
    public void clear() throws Exception {
        Resume[] resumes = {new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)};
        storage.clear();
        assertSize(0);
    }

    private void assertArraySort(Resume resumes1, Resume resume1, Resume resume, Resume resumes) {
        List<Resume> array = Arrays.asList(resumes);
        assertTrue(array.containsAll(Arrays.asList(storage.getAll())));
    }

    @Test
    public void save() throws Exception {
        Resume[] resumes = {new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3), new Resume(UUID_4)};
        Resume r2 = new Resume(UUID_2);
        storage.save(r2);
        assertArraySort(new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3), new Resume(UUID_4));
        assertArrayEquals(resumes, storage.getAll());

    }


    @Test
    public void delete() throws Exception {
        Resume[] resumes = {new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3), new Resume(UUID_4)};
        storage.delete(UUID_3);
        assertArraySort(new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_4));
        assertArrayEquals(resumes, storage.getAll());
    }

    protected abstract void assertArraySort(Resume resume2, Resume resume, Resume resume1);


    @Test
    public void update() throws Exception {
        Resume r3 = new Resume(UUID_3);
        storage.update(r3);
        assertEquals(r3, storage.get(UUID_3));

    }

    @Test
    public void get() throws Exception {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);


    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(RESUME_1);

    }

    @Test(expected = StorageException.class)
    public void testSaveStorageException() {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        }catch (StorageException e){
            Assert.fail();

        }
        storage.save(new Resume());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");

    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(RESUME_1);


    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");

    }

    @Test
    public void size() throws Exception {
        assertSize(3);

    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }

    @Test
    public void getAll() throws Exception {
        Resume[] resumes = {new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)};
        storage.getAll();
        assertArrayEquals(resumes, storage.getAll());


    }


}
