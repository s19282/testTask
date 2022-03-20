package com.company;

import java.util.ArrayList;
import java.util.List;

public class Test implements CompositeBlock{
    List abc;

    public Test(List abc) {
        this.abc = abc;
    }

    @Override
    public String getColor() {
        System.out.println("getColor");
        return null;
    }

    @Override
    public String getMaterial() {
        System.out.println("getMaterial");
        return null;
    }

    @Override
    public List getBlocks() {
        System.out.println(abc);
        System.out.println("getBlocks");
        return abc;
    }
}
