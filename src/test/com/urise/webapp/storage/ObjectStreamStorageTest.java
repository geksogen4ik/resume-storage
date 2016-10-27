package test.com.urise.webapp.storage;


import com.urise.webapp.storage.ObjectStreamStorage;
import com.urise.webapp.storage.Storage;

/**
 * Created by Sveta on 26.10.2016.
 */
public class ObjectStreamStorageTest extends AbstractStorageTest {
    public ObjectStreamStorageTest(){
        super((Storage) new ObjectStreamStorage(STORAGE_DIR));
    }
}
