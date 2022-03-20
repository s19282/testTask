package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static List<Test> myList = new ArrayList<>();

    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println("Hello world!");
        Test t = new Test();
        System.out.println(myList.getClass().getComponentType());

//        System.out.println(Arrays.toString(t.getClass().getDeclaredMethods()));
//        System.out.println(t.getClass().getMethod("getBlocks"));
//        t.getClass().getMethod("getBlocks");
        try {
            Field integerListField = Main.class.getDeclaredField("myList");
            ParameterizedType integerListType = (ParameterizedType) integerListField.getGenericType();
            System.out.println(integerListType);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
//        myList.getClass().getMethod("getBlocks");
//        System.out.println(Arrays.toString(t.getClass().getInterfaces()));
//        System.out.println(Arrays.toString(t.getClass().getInterfaces()[0].getInterfaces()[0].getDeclaredMethods()));
//        System.out.println(Arrays.toString(t.getClass().getInterfaces()[0].getDeclaredMethods()));
    }
}
