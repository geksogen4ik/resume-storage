package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by Sveta on 14.10.2016.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Resume implements Comparable<Resume>, Serializable{
    private static final long serialVersionUID = 1L;

    // Unique identifier
    private  String uuid;

    private  String fullName;

    private final Map<ContactType,String> contacts = new EnumMap<>(ContactType.class);
    private final Map<SectionType,Section> sections = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullname) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullname, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullname;
    }

    public Resume() {
    }


    @Override
    public String toString() {

        return uuid + "(" + fullName + ")";
    }

    public String getUuid() {

        return uuid;
    }
    public void addContact(ContactType type, String contact) {
        contacts.put(type, contact);
    }
    public String getContact(ContactType type) {
        return contacts.get(type);
    }
    public void addSection(SectionType type, Section section) {
        sections.put(type, section);
    }

    public Section getSection(SectionType type) {
        return sections.get(type);
    }

    public String getFullName() {
        return fullName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) &&
                Objects.equals(fullName, resume.fullName) &&
                Objects.equals(contacts, resume.contacts) &&
                Objects.equals(sections, resume.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, contacts, sections);
    }

    @Override
    public int compareTo(Resume o) {
        int cmp =  fullName.compareTo(o.fullName);
        return cmp !=0? cmp: uuid.compareTo(o.uuid);
    }

    public void addSection(SectionType qualifications, ListSection listSection) {
    }


}
