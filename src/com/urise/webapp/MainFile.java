package com.urise.webapp;


import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sveta on 23.10.2016.
 */
public class MainFile {

    public List<File> addFiles(List<File> files, File directory) {
        if (files == null)
            files = new LinkedList<File>();
        if (!directory.isDirectory()) {
            files.add(directory);
            return files;
        }
        for (File file : directory.listFiles())
            addFiles(files, file);
        return files;
    }
}
