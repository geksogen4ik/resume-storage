package test.com.urise.webapp.storage;

import com.urise.webapp.storage.PathStorage;
import com.urise.webapp.storage.serializer.XmlStreamSerializer;

/**
 * Created by Sveta on 04.11.2016.
 */
public class XmlPathStorageTest extends AbstractStorageTest {
    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamSerializer()));
    }
}

