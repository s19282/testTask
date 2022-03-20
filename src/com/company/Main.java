package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static List<Test> myList = new ArrayList<>();

    public static void main(String[] args) throws NoSuchMethodException {
        List<String> abcc = new ArrayList<>();
        abcc.add("test");
        abcc.add("vcjkl");
        Test t = new Test(abcc);
        List<Test> list = new ArrayList<>();
        list.add(t);
        Wall wall = new Wall();
        wall.setBlocks(list);
        wall.findBlockByColor("red");
    }
}
