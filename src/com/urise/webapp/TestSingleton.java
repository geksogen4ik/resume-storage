package com.urise.webapp;

import com.urise.webapp.model.SectionType;

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
        Singleton instance = Singleton.valueOf("INSTANCE");
        System.out.println(instance.ordinal());
        for( SectionType type: SectionType.values()){
            System.out.println(type.getTitle());
        }
    }

    public enum Singleton{
        INSTANCE;
    }
}
