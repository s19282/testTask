package com.company;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List blocks;

    @Override
    public Optional findBlockByColor(String color) {
        List matchColourBlocks;
        blocks.forEach(compositeBlock -> compositeBlock.getBlocks().forEach(block -> {
            if(block.getColor().equals(color)) matchColourBlocks.add(block);
        }));
        if(matchColourBlocks.isEmpty())
            return Optional.empty();
        else
            return Optional.of(matchColourBlocks);
    }

    @Override
    public List findBlocksByMaterial(String material) {
        List matchMaterialBlocks;
        blocks.forEach(compositeBlock -> compositeBlock.getBlocks().forEach(block -> {
            if(block.getMaterial().equals(material)) matchMaterialBlocks.add(block);
        }));
        return matchMaterialBlocks;
    }

    @Override
    public int count() {
        int counter=0;
        for (Object compositeBlock : blocks) {
            counter+=compositeBlock.getBlocks().size();
        }
        return counter;
    }
}