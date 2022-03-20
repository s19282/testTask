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

    @Override
    public Optional findBlockByColor(String color) {
        List matchColourBlocks;
        if(!blocks.isEmpty()) {
            try {
                List hmm = (List)blocks.get(0).getClass().getMethod("getBlocks").invoke(blocks.get(0));
                hmm.forEach(block -> {
                    try {
                        block.getClass().getMethod("getColor").invoke(block);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                });

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        //        List<Class<? extends CompositeBlock>> list = new ArrayList<>();
//        blocks.getClass().getInterfaces()[0].getMethod("getBlocks")
//        for (Class<? extends CompositeBlock> el : blocks)
//        blocks.forEach(compositeBlock -> compositeBlock.getBlocks().forEach(block -> {
//            if(block.getColor().equals(color)) matchColourBlocks.add(block);
//        }));
//        if(matchColourBlocks.isEmpty())
//            return Optional.empty();
//        else
//            return Optional.of(matchColourBlocks);
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