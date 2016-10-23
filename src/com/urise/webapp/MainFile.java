package com.urise.webapp;

import java.io.File;
import java.io.IOException;

/**
 * Created by Sveta on 23.10.2016.
 */

public class MainFile {
    public static void main(String[] args) throws IOException {
        File file = new File(" ");
        System.out.println(file.getCanonicalPath());
        listPath(file.getCanonicalPath());

    }

    public static void listPath(String path) throws IOException {
        File file = new File(path);
        for (File files : file.listFiles()) {
            if (files.isDirectory()) {
                listPath(files.getCanonicalPath());
            } else {
                System.out.println(files.getCanonicalPath());
            }
        }

    }
}


