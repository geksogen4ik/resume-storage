package com.urise.webapp;

/**
 * Created by Sveta on 17.10.2016.
 */
public class TestSingleton {
    private static TestSingleton instance= new TestSingleton();

    public static TestSingleton getInstance() {
        if (instance== null){
            instance= new TestSingleton();
        }


        return instance;
    }

    private TestSingleton() {
    }
    public static void main (String[] args){
        TestSingleton.getInstance().toString();
    }

    public enum Singleton{
        INSTANCE;
    }
}
