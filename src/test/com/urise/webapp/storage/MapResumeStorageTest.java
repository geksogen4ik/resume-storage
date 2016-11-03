package test.com.urise.webapp.storage;


import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.MapResumeStorage;

/**
 * Created by Sveta on 17.10.2016.
 */

    public class MapResumeStorageTest extends AbstractStorageTest {

        public MapResumeStorageTest() {
            super(new MapResumeStorage() {

                @Override
                protected Resume getSearchKey(String uuid) {
                    return null;
                }
            });
        }
    }


