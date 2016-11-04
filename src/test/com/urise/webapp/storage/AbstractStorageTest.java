package test.com.urise.webapp.storage;

import com.urise.webapp.model.*;
import com.urise.webapp.storage.Storage;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sveta on 17.10.2016.
 */
public class AbstractStorageTest {

    protected static final String STORAGE_DIR = "C:\\Users\\Sveta\\IdeaProjects\\resume-storage\\storage";

    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;



    static {

        RESUME_1 = new Resume(UUID_1, "name1");
        RESUME_2 = new Resume(UUID_2, "name2");
        RESUME_3 = new Resume(UUID_3, "name3");
        RESUME_4 = new Resume(UUID_4, "name4");

        RESUME_1.addContact(ContactType.MAIL, "mail@ya.ru");
        RESUME_1.addContact(ContactType.PHONE, "11111");
        RESUME_1.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        RESUME_1.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        RESUME_1.addSection(SectionType.ACHIEVEMENT, new ListSection("Achievement11", "Achievement12", "Achievement13"));
        RESUME_1.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        RESUME_1.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization11", "http://Organization11.ru",
                                new Organization.Position(2005, Month.JANUARY, "position1", "content1"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        RESUME_1.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", null,
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization12", "http://Organization12.ru")));

        RESUME_1.addContact(ContactType.SKYPE, "skype2");
        RESUME_1.addContact(ContactType.PHONE, "22222");
        RESUME_1.addSection(SectionType.EXPERIENCE,
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
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void testClear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void testUpdate() throws Exception {
        Resume r = new Resume(UUID_3, "New Name");
        storage.update(r);
        assertEquals(r, storage.get(UUID_3));
    }

    @Test
    public void testSave() throws Exception {
        storage.save(RESUME_4);
        assertArrayWithSort(RESUME_1,RESUME_2,RESUME_3,RESUME_4);
    }

    @Test
    public void testGet() throws Exception {
        assertEquals(RESUME_1, storage.get(UUID_1));
        assertEquals(RESUME_2, storage.get(UUID_2));
        assertEquals(RESUME_3, storage.get(UUID_3));
    }

    @Test
    public void testDelete() throws Exception {
        storage.delete(UUID_1);
        assertArrayWithSort(RESUME_2,RESUME_3);
    }

    @Test
    public void testGetAll() throws Exception {
        assertArrayWithSort(RESUME_1,RESUME_2,RESUME_3);
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(3, storage.size());
    }

    private void assertArrayWithSort(Resume... resumes){
        List<Resume> arr = Arrays.asList(resumes);
        assertTrue(arr.containsAll(storage.getAllSorted()));
    }

}