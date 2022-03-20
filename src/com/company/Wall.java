package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List blocks;

    @Override
    public Optional findBlockByColor(String color) {
//        List matchColourBlocks;
////        List<Class<? extends CompositeBlock>> list = new ArrayList<>();
//        blocks.getClass().getInterfaces()
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