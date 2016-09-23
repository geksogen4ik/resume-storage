/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size = 0;
    private int storageMaxLength = 10000;

    private Resume[] storage = new Resume[storageMaxLength];

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    private int getIndex(String uuid) {
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

        if (size == storageMaxLength) {
            System.out.println("ERROR: Storage is full");
            return;
        }
        {

            storage[size] = r;
            size++;
        }
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




    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("ERROR: This " + r + " don't exist, if you want to create, click  - save");
        }
        storage[index] = r;
    }




    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    public int size() {


        return size;
    }
}