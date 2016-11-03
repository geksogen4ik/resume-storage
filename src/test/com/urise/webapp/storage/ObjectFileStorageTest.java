package test.com.urise.webapp.storage;

import com.urise.webapp.storage.FileStorage;
import com.urise.webapp.storage.serializer.ObjectStreamSerializer;

import java.io.File;

/**
 * Created by Sveta on 03.11.2016.
 */
public class ObjectFileStorageTest extends AbstractStorageTest{

    public ObjectFileStorageTest() {
        super(new FileStorage(new File(String.valueOf(STORAGE_DIR)), new ObjectStreamSerializer()));
    }
}
