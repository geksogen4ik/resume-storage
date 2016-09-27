package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Created by Sveta on 25.09.2016.
 */
public class ArrayStorage extends AbstractArrayStorage {

    protected int getIndex(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if ((storage[i].getUuid().equals(uuid))) {
                index = i;
            }
        }
        return index;
    }

    public void save(Resume r) {

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
        if (index == -1) {System.out.println("ERROR: This " + uuid + " don't exist, if you want to create, click  - save");{
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
            return null;
        }

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


    @Override
    protected void insertElement(Resume r, int index) {
        storage[size] = r;
    }

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[size];
    }

}
