package com.urise.webapp;

import java.io.File;
import java.io.IOException;

/**
 * Created by Sveta on 23.10.2016.
 */

public class MainFile {
    public static void main(String[] args) {
        File file = new File(".\\src");

        printDirectoryDeeply(file, "");

    }

    public static void printDirectoryDeeply(File dir, String offset) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(offset + "F: " + file.getName());
                } else if (file.isDirectory()){
                    System.out.println(offset + "D: " + file.getName());
                    printDirectoryDeeply(file, offset + "  ");
                }
            }
        }
    }

    public static void printPrettyDirectoryDeeply(File file) {
        System.out.println(/*"Root:" + */file.getName());

        File[] files = file.listFiles();

        if (files != null) {
            String prefix = file.getName().replaceAll(".", " ");
            for (File f : files) {
                //printPrettyDirectoryDeeply(f, 0);
                printPrettyDirectoryDeeply(f, prefix);
            }
        }
    }

    private static void printPrettyDirectoryDeeply(File file, int level) {
        for (int i = 0; i < level + 1; i++) {
            System.out.print("\t");
        }

        if (file.isDirectory()) {
            System.out.println(/*"Directory: " + */file.getName());
            File[] files = file.listFiles();

            if (files != null) {
                for (File f : files) {
                    printPrettyDirectoryDeeply(f, level + 1);
                }
            }
        } else if (file.isFile()) {

            System.out.println(/*"File: " + */file.getName());
        }
    }

    private static void printPrettyDirectoryDeeply(File file, String prefix) {
        System.out.print(prefix);

        if (file.isDirectory()) {
            System.out.println(file.getName());
            File[] files = file.listFiles();

            if (files != null) {
                prefix += file.getName().replaceAll(".", " ");
                for (File f : files) {
                    printPrettyDirectoryDeeply(f, prefix);
                }
            }
        } else if (file.isFile()) {

            System.out.println(file.getName());
        }
    }


}


