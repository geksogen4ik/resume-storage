package com.urise.webapp; /**
 * Created by Sveta on 29.09.2016.
 */

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume("Name");
        Class<? extends Resume> resumeClass = r.getClass();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");

        Method method = resumeClass.getMethod("toString");
        Object results = method.invoke(r);
        System.out.println(results);
    }
}