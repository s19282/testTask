package com.company;

import java.util.List;

public class BigBrick implements CompositeBlock{
    private List<Brick> blocks;

    public void setBlocks(List<Brick> blocks) {
        this.blocks = blocks;
    }

    @Override
    public String getColor() {
        return blocks.get((int)(Math.random()*blocks.size())).getColor();
    }

    @Override
    public String getMaterial() {
        return blocks.get((int)(Math.random()*blocks.size())).getMaterial();
    }

    @Override
    public List getBlocks() {
        return blocks;
    }
}
