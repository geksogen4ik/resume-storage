package com.urise.webapp.exeption;

/**
 * Created by Sveta on 29.09.2016.
 */
public class ExistStorageException extends StorageException{
    public ExistStorageException(String uuid){
        super("Resume" + uuid + " already exist", uuid);
    }
}
