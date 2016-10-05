package storage.test;

import exeption.NotExistStorageException;
import exeption.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import storage.AbstractArrayStorage;
import storage.ArrayStorage;
import storage.SortedArrayStorage;
import storage.Storage;

import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * Created by Sveta on 29.09.2016.
 */
public abstract class AbstractArrayStorageTest {


    private Storage storage = new ArrayStorage();

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    public AbstractArrayStorageTest(ArrayStorage arrayStorage) {
    }

    public AbstractArrayStorageTest(SortedArrayStorage sortedArrayStorage) {
    }


    @Before
    public void setUp() throws Exception{
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));

    }
    @Test
    public void clear() throws Exception {
        Resume [] resumes = {new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)};
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void save() throws Exception {
        Resume r4 = new Resume(UUID_4);
        storage.save(r4);
        Assert.assertEquals(r4,storage.get(UUID_4));
    }

        @Test(expected = StorageException.class)
        public void testSaveStorageException() {
            for (int i = 0; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        }



    @Test
    public void delete() throws Exception {
        Resume[] resumes = {new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)};
        storage.delete(UUID_1);
        Assert.assertArrayEquals(resumes, storage.getAll());
    }

    @Test
    public void update() throws Exception {
        Resume r3 = new Resume(UUID_3);
        storage.update(r3);
        Assert.assertEquals(r3,storage.get(UUID_3));

    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(UUID_1, storage.get(UUID_1));

    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");

    }
    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        Resume r3 = new Resume(UUID_3);
        storage.update(r3);


    }
    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete(UUID_1);

    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());

    }

    @Test
    public void getAll() throws Exception {
        Resume [] resumes = {new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)};
        storage.getAll();
        Assert.assertArrayEquals(resumes, storage.getAll());



    }


}