package test.com.urise.webapp.storage;

import com.urise.webapp.model.*;
import com.urise.webapp.storage.Storage;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sveta on 17.10.2016.
 */
public class AbstractStorageTest {

    protected static final File STORAGE_DIR = new File("C:\\Users\\Sveta\\IdeaProjects\\resume-storage\\src\\com\\urise\\webapp\\storage");
    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    protected Storage storage;

    public static final String UUID_1 = "uuid1";
    public static final String UUID_2 = "uuid2";
    public static final String UUID_3 = "uuid3";
    public static final String UUID_4 = "uuid4";

    public static final Resume R1;
    public static final Resume R2;
    public static final Resume R3;
    public static final Resume R4;


    static {
        R1 = new Resume(UUID_1, "FullName1");
        R2 = new Resume(UUID_2, "FullName1");
        R3 = new Resume(UUID_3, "FullName1");
        R4 = new Resume(UUID_4, "FullName1");

        R1.addContact(ContactType.MAIL, "mail@ya.ru");
        R1.addContact(ContactType.PHONE, "11111");
        R1.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        R1.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        R1.addSection(SectionType.ACHIEVEMENT, new ListSection("Achievement11", "Achievement12", "Achievement13"));
        R1.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        R1.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization11", "http://Organization11.ru",
                                new Organization.Position(2005, Month.JANUARY, "position1", "content1"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        R1.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", null,
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization12", "http://Organization12.ru")));

        R2.addContact(ContactType.SKYPE, "skype2");
        R2.addContact(ContactType.PHONE, "22222");
        R2.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization21", "http://Organization21.ru",
                                new Organization.Position(2015, Month.JANUARY, "position1", "content1"))));
    }
    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @Test
    public void testClear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void testUpdate() throws Exception {
        Resume r = new Resume(UUID_1, "New Name");
        storage.update(r);
        assertEquals(r, storage.get(UUID_1));
    }

    @Test
    public void testSave() throws Exception {
        storage.save(R4);
        assertArrayWithSort(R1, R2, R3, R4);
    }

    @Test
    public void testGet() throws Exception {
        assertEquals(R1, storage.get(UUID_1));
        assertEquals(R2, storage.get(UUID_2));
        assertEquals(R3, storage.get(UUID_3));
    }

    @Test
    public void testDelete() throws Exception {
        storage.delete(UUID_1);
        assertArrayWithSort(R2, R3);
    }

    @Test
    public void testGetAllSorted() throws Exception {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        assertEquals(list, Arrays.asList(R1, R2, R3));
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(3, storage.size());
    }

    private void assertArrayWithSort(Resume... resumes) {
        List<Resume> arr = Arrays.asList(resumes);
        assertTrue(arr.containsAll(storage.getAllSorted()));
    }

}

