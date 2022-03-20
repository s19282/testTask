package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Test t = new Test();
        System.out.println(Arrays.toString(t.getClass().getInterfaces()));
        System.out.println(Arrays.toString(t.getClass().getInterfaces()[0].getInterfaces()[0].getDeclaredMethods()));
        System.out.println(Arrays.toString(t.getClass().getInterfaces()[0].getDeclaredMethods()));
    }
}
