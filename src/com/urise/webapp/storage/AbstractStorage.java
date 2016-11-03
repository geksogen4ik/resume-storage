package com.urise.webapp.storage;
import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;
import java.util.Collections;
import java.util.List;


/**
 * Created by Sveta on 14.10.2016.
 */
public abstract class AbstractStorage<SK> implements Storage {

    public abstract int getSize();

    protected abstract SK getSearchKey(String uuid);

    protected abstract boolean isExist(SK searchKey);

    protected abstract void doSave(Resume r, SK searchKey);

    protected abstract void doDelete(SK searchKey);

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doUpdate(Resume r, SK searchKey);

    public abstract List<Resume> doCopyAll();

    public void save(Resume r){
        SK searchKey = getNotExistSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    public void delete(String uuid) {
        SK searchKey = getExistSearchKey(uuid);
        doDelete(searchKey);
    }

    public Resume get(String uuid) {
        SK searchKey = getExistSearchKey(uuid);
        return doGet(searchKey);
    }

    public void update(Resume r) {
        SK searchKey = getExistSearchKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    private SK getExistSearchKey(String uuid){
        SK searchKey = getSearchKey(uuid);
        if(!isExist(searchKey)){
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistSearchKey(String uuid){
        SK searchKey = getSearchKey(uuid);
        if(isExist(searchKey)){
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;

    }

}
