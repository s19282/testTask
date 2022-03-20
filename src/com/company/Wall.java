package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List blocks;

    public List getBlocks() {
        return blocks;
    }

    public void setBlocks(List blocks) {
        this.blocks = blocks;
    }
//TODO: check with more test elements
    @Override
    public Optional findBlockByColor(String color) {
        List matchColourBlocks;
        for (Object block : blocks) {
            try {
                System.out.println("a");
                List hmm = (List)block.getClass().getMethod("getBlocks").invoke(blocks.get(0));
                block.getClass().getMethod("getColor").invoke(blocks.get(0));

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List findBlocksByMaterial(String material) {
        List matchMaterialBlocks;
//        blocks.forEach(compositeBlock -> compositeBlock.getBlocks().forEach(block -> {
//            if(block.getMaterial().equals(material)) matchMaterialBlocks.add(block);
//        }));
//        return matchMaterialBlocks;
        return null;
    }

    @Override
    public int count() {
        int counter=0;
//        for (Object compositeBlock : blocks) {
//            counter+=compositeBlock.getBlocks().size();
//        }
        return counter;
    }
}