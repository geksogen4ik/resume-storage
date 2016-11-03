package test.com.urise.webapp.storage;



import com.urise.webapp.storage.PathStorage;
import com.urise.webapp.storage.serializer.ObjectStreamSerializer;



/**
 * Created by Sveta on 26.10.2016.
 */
public class ObjectPathStorageTest extends AbstractStorageTest {
    public ObjectPathStorageTest(){

        super(new PathStorage(STORAGE_DIR, new ObjectStreamSerializer()));
    }
}
