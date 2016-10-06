package storage;

import exeption.ExistStorageException;
import exeption.NotExistStorageException;
import exeption.StorageException;
import model.Resume;

import java.util.Arrays;

/**
 * Created by Sveta on 25.09.2016.
 */


    public abstract class AbstractArrayStorage implements Storage{



        public static final int STORAGE_LIMIT = 10000;


    protected Resume[] storage = new Resume[STORAGE_LIMIT];
        protected int size;

        public void clear() {
            Arrays.fill(storage, 0, size, null);
            size = 0;
        }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index  >= 0) {
            throw new ExistStorageException(r.getUuid());
        }
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());

        }
        {   insertElement(r, index);
            storage[size] = r;
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }else{
            {
                fillDeletedElement(index);
                storage[index] = storage[size];
                size--;
                System.out.println("Resume delete" + uuid);

            }
        }
    }
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
           throw new NotExistStorageException(r.getUuid());
        }
        storage[index] = r;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }

        {
            return storage[index];
        }

    }
    public int size() {
        return size;
    }


    public Resume[] getAll() {

        return Arrays.copyOfRange(storage, 0, size);
        }

        protected abstract int getIndex(String uuid);

        protected abstract void insertElement(Resume r, int index);

        protected abstract void fillDeletedElement(int index);

    }

