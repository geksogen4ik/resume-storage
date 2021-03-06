/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    int size = 0;
    int storageMaxLenth = 10000;
    Resume[] storage = new Resume[storageMaxLenth];

    void clear() {
        for (int i = 0; i < size; i++) {
                storage[i] = null;
            }
            size = 0;
    }

    void save(Resume r) {
         if (size == storageMaxLenth) {
            System.out.println("Хранилище переполнено!");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                System.out.println("Такое " + r + "резюме уже существует");
                return;
            }
        }
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
                    if (storage[i].getUuid().equals(uuid))
                    {
                        return storage[i];
                    }
                }
              System.out.println("Такого " + uuid + " резюме не существует, если хотите создать нажмите - save");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[size];
                storage[size] = null;
                size--;
                System.out.println("Резюме удалено " + uuid);
            } else System.out.println("Такого " + uuid + " резюме не существует, если хотите создать нажмите - save");
           
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
          Resume[] resumes = new Resume[size];
            for (int i = 0; i < size; i++) {
                resumes[i] = storage[i];
            }
            return resume;
    }

    int size() {
        return size;
    }
}
