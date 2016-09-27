package storage;

import model.Resume;

/**
 * Created by Sveta on 25.09.2016.
 */
public class ArrayStorage extends AbstractArrayStorage{
    private int size = 0;
    private int storageMaxLength = 10000;
    private Resume[] storage = new Resume[storageMaxLength];

    
    protected int getIndex(String uuid){
        int index = -1;
        for (int i = 0; i < size; i++) {
            if ((storage[i].getUuid().equals(uuid))) {
                index = i;
            }
        }
        return index;
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
