package test.com.urise.webapp.storage;
import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.AbstractArrayStorage;
import com.urise.webapp.storage.Storage;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Sveta on 29.09.2016.
 */
public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
      super(storage);
    }


    @Test(expected = StorageException.class)
    public void testSaveStorageException() {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("name" + i));
            }
        } catch (StorageException e) {
            Assert.fail();

        }
        storage.save(new Resume("Overflow"));
    }
}

