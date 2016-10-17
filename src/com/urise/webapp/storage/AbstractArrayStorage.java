package com.urise.webapp.storage;


import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sveta on 25.09.2016.
 */


public abstract class AbstractArrayStorage extends AbstractStorage<Integer>{
    public static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    protected abstract Integer getSearchKey (String uuid);

    protected abstract void insertElement(Resume r, int index);

    protected abstract void fillDeletedElement(int index);

    @Override
    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    @Override
    protected void doSave(Resume r, Integer index) {
        if (size == storage.length){
            throw new StorageException("Storage overflow", r.getUuid());
        }
        insertElement(r, index);
        size++;
    }

    @Override
    protected void doUpdate(Resume r, Integer index) {
        storage[(Integer)index] = r;
    }

    @Override
    protected void doDelete(Integer index) {
        fillDeletedElement(index);
        storage[size-1] = null;
        size--;
    }

    @Override
    protected Resume doGet(Integer index) {
        return storage[index];
    }

    @Override
    protected boolean isExist(Integer index) {
        return (index) >= 0;
    }


    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }
}