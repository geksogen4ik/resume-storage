package com.urise.webapp.storage;
import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.List;


/**
 * Created by Sveta on 14.10.2016.
 */
public abstract class AbstractStorage<R> implements Storage {

    protected abstract Object getSearchKey(String uuid);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doSave(Resume r, Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doUpdate(Resume r, Object searchKey);

    public abstract Resume[] getAll();

    protected abstract void doSave(Resume r, Resume resume);

    protected abstract void doDelete(Resume resume);

    protected abstract Resume doGet(Resume resume);

    protected abstract void doUpdate(Resume r, Resume resume);

    protected abstract boolean isExist(Resume resume);

    public abstract List<Resume> doCopyAll();

    public void save(Resume r){
        Object searchKey = getNotExistSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistSearchKey(uuid);
        doDelete(searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = getExistSearchKey(uuid);
        return doGet(searchKey);
    }

    public void update(Resume r) {
        Object searchKey = getExistSearchKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    private Object getExistSearchKey(String uuid){
        Object searchKey = getSearchKey(uuid);
        if(!isExist(searchKey)){
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistSearchKey(String uuid){
        Object searchKey = getSearchKey(uuid);
        if(isExist(searchKey)){
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }


}


