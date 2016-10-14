package com.urise.webapp.exeption;

/**
 * Created by Sveta on 29.09.2016.
 */
public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Resume" + uuid + " not exist", uuid);
    }
}
