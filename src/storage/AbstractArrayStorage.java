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

        public void save(Resume r){

            int index = getIndex(r.getUuid());
            if (index == -1) {
                System.out.println("ERROR: The same " + r + "resume already exists");
                return;
            }

            if (size == STORAGE_LIMIT) {
                System.out.println("ERROR: Storage is full");
                return;
            }
            {

                storage[size] = r;
                size++;
            }
        }


    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR: This " + uuid + " don't exist, if you want to create, click  - save");
            {
                storage[index] = storage[size];
                size--;
                System.out.println("Resume delete" + uuid);
                return;
            }

        }
    }

        public int size() {
            return size;
        }

        public Resume get(String uuid) {
            int index = getIndex(uuid);
            if (index == -1) {
                System.out.println("ERROR: This " + uuid + " don't exist, if you want to create, click  - save");
                return null;}

            {
                return storage[index];
            }

        }


    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("ERROR: This " + r + " don't exist, if you want to create, click  - save");
        }
        storage[index] = r;
    }

        public Resume[] getAll() {
            return Arrays.copyOf(storage, size);
        }

        protected abstract int getIndex(String uuid);

        protected abstract void insertElement(Resume r, int index);

        protected abstract void fillDeletedElement(int index);

    }

