package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Created by Sveta on 17.10.2016.
 */
public abstract class MapResumeStorage extends AbstractStorage<Resume>{

    Map<String,Resume> map= new HashMap<>();
    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAllSorted() {

        return Collections.EMPTY_LIST;
    }

    @Override
    public int size() {
        return map.size();
    }



    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }

    @Override
    protected void doSave(Resume r, Resume resume) {
        map.put(r.getUuid(), r);

    }

    @Override
    protected void doDelete(Resume resume) {
        map.remove(resume.getUuid());

    }

    @Override
    protected Resume doGet(Resume resume) {
        return  resume;
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {
        map.put(r.getUuid(), r);

    }


    @Override
    public List<Resume> doCopyAll() {

        return new ArrayList<>(map.values());
    }
}
