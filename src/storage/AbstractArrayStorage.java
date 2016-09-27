package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Created by Sveta on 25.09.2016.
 */


    public abstract class AbstractArrayStorage implements Storage{



        protected static final int STORAGE_LIMIT = 10000;

        protected Resume[] storage = new Resume[STORAGE_LIMIT];
        protected int size;

        public void clear() {
            Arrays.fill(storage, 0, size, null);
            size = 0;
        }

    public void save(Resume r) {
    }
    public void delete(String uuid) {
    }
    public void update(Resume r) {
    }
    public Resume get(String uuid) {
        return null;
    }
    public int size() {
        return size;
    }




    public Resume[] getAll() {
            return Arrays.copyOf(storage, size);
        }

        protected abstract int getIndex(String uuid);

        protected abstract void insertElement(Resume r, int index);

        protected abstract void fillDeletedElement(int index);

    }

