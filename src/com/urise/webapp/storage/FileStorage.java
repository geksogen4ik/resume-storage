package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.serializer.StreamSerializer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File> {

    private File directory;

    private StreamSerializer streamSerializer;

    public FileStorage(File directory, StreamSerializer serializer) {
        Objects.requireNonNull(directory, "directory must not be null");
        if(!directory.isDirectory()){
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if(!directory.canRead() || !directory.canWrite()){
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
        this.streamSerializer = serializer;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("Couldn't create file " + file.getAbsolutePath(), file.getName(), e);
        }
        doUpdate(r, file);
    }

    @Override
    protected void doDelete(File file) {
        if(!file.delete()){
            throw new StorageException("File delete error", file.getName());
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return streamSerializer.doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File read error", file.getName(), e);
        }
    }

    @Override
    protected void doUpdate(Resume r, File file) {
        try {
            streamSerializer.doWrite(r, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File write error", file.getName(), e);
        }
    }

    @Override
    public List<Resume> doCopyAll() {
        File[] files =directory.listFiles();
        if(files == null){
            throw new StorageException("Directory read error");
        }

        List<Resume> list = new ArrayList<>(files.length);
        for (File file: files){
            list.add(doGet(file));
        }
        return list;
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if(files != null){
            for (File file: files){
                doDelete(file);
            }
        }
    }

    @Override
    public int size() {
        String[] list = directory.list();
        if(list == null){
            throw new StorageException("Directory read error");
        }
        return list.length;
    }
}
