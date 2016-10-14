package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sveta on 06.10.2016.
 */
public class MapUUidStorage extends AbstractStorage<R> {
    Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        return null;
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object searchKey) {

        return storage.containsKey(searchKey);
    }

    @Override
    protected boolean isExist(Resume resume) {
        return false;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {

        storage.put((String) searchKey, r);
    }


    @Override
    protected void doDelete(Object searchKey) {

        storage.remove(searchKey);
    }

    @Override
    protected Resume doGet(Object searchKey) {

        return storage.get(searchKey);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey)
    {
        storage.put((String) searchKey, r);
    }

    @Override
    public Resume[] getAll() {

        return storage.values().toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(storage.values());
    }

}