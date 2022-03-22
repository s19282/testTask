package com.company;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Brick b1 = new Brick();
        b1.setColor("c1");
        b1.setMaterial("m1");
        Brick b2 = new Brick();
        b2.setColor("c1");
        b2.setMaterial("m2");
        Brick b3 = new Brick();
        b3.setColor("c1");
        b3.setMaterial("m3");

        List<Brick> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);

        Wall wall = new Wall();
        wall.setBlocks(list);
        wall.findBlockByColor("c1");
    }
}
