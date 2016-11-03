package com.urise.webapp.storage;


/**
 * Created by Sveta on 14.10.2016.
 */
public class MainUtil {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf(-1) == Integer.valueOf(-1));
        System.out.println(Integer.valueOf(-1) == new Integer(-1));
        int result = getInt();
        System.out.printf(String.valueOf(result));
    }
    private static Integer getInt(){
        return -1;

    }
}
