package test.com.urise.webapp.storage;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Sveta on 17.10.2016.
 */



    @RunWith(Suite.class)
    @Suite.SuiteClasses(
            {
                    ArrayStorageTest.class,
                    SortedArrayStorageTest.class,
                    ListStorageTest.class,
                    MapUuidStorageTest.class,
                    MapResumeStorageTest.class,
                    ObjectStreamStorageTest.class,
            }
    )
    public class AllStorageTest {
    }

