package com.urise.webapp;

import java.io.File;
import java.io.IOException;

/**
 * Created by Sveta on 23.10.2016.
 */

public class MainFile {
    public static void main(String[] args) {
        File file = new File(".\\src");

        printPrettyDirectoryDeeply(file);
    }

    public static void printDirectoryDeeply(File file) {
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    System.out.println("Directory:" + f.getPath());
                    printDirectoryDeeply(f);
                } else {
                    System.out.println("File:" + f.getPath());
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


