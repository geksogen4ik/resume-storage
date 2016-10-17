package com.urise.webapp.storage;


import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sveta on 06.10.2016.
 */

public class ListStorage extends AbstractStorage<Resume> {

    private List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void update(Resume r) {
        int ind = storage.indexOf(r);
        if(ind == -1){
            throw new NotExistStorageException(r.getUuid());
        }
        storage.add(ind, r);
    }

    @Override
    public List<Resume> getAllSorted() {
        return null;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i<storage.size(); i++){
            if(storage.get(i).getUuid().equals(uuid)){
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {

        storage.add(r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove(((Integer)searchKey).intValue());
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get((Integer)searchKey);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storage.set((Integer)searchKey, r);
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override
    protected void doSave(Resume r, Resume resume) {

    }

    @Override
    protected void doDelete(Resume resume) {

    }

    @Override
    protected Resume doGet(Resume resume) {
        return null;
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {

    }

    @Override
    protected boolean isExist(Resume resume) {
        return false;
    }

    @Override
    public List<Resume> doCopyAll() {
        return null;
    }

    @Override
    public int size() {
        return storage.size();
    }

}