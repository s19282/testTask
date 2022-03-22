package com.company;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Brick b1 = new Brick();
        b1.setColor("c1");
        b1.setMaterial("m1");
        Brick b2 = new Brick();
        b2.setColor("c2");
        b2.setMaterial("m2");
        Brick b3 = new Brick();
        b3.setColor("c3");
        b3.setMaterial("m3");
        Brick b4 = new Brick();
        b4.setColor("c4");
        b4.setMaterial("m3");


        BigBrick bb1 = new BigBrick();
        List<Brick> bb1List = new ArrayList<>();
        bb1List.add(b1);
        bb1List.add(b2);
        bb1.setBlocks(bb1List);
        BigBrick bb2 = new BigBrick();
        List<Brick> bb2List = new ArrayList<>();
        bb2List.add(b3);
        bb2List.add(b4);
        bb2.setBlocks(bb2List);
        List<BigBrick> l1 = new ArrayList<>();
        l1.add(bb2);
        l1.add(bb1);

        Wall wall = new Wall();
        wall.setBlocks(l1);

//        List<Brick> list = new ArrayList<>();
//        list.add(b1);
//        list.add(b2);
//        list.add(b3);
//
//        Wall wall = new Wall();
//        wall.setBlocks(list);
        wall.findBlockByColor("c1");
    }
}
