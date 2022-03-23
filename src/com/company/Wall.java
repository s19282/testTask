package com.company;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if(blocks.isEmpty())
        {
            return Optional.empty();
        }
        else
        {
            String interfaces = Arrays.toString(blocks.get(0).getClass().getInterfaces());
            System.out.println(interfaces);
            Pattern patternBlock = Pattern.compile(".+interface com\\.company\\.Block.+");
            Pattern patternCompositeBlock = Pattern.compile(".+interface com\\.company\\.CompositeBlock.+");
            Matcher matcher = patternCompositeBlock.matcher(interfaces);
            if(matcher.matches())
            {
                for (Object block : blocks) {
                    try {
                        List getBlocks = (List) block.getClass().getMethod("getBlocks").invoke(block);
                        for(Object o : getBlocks)
                        {
                            String c = o.getClass().getMethod("getColor").invoke(o).toString();
                            if(color.equals(c)) {
                                return Optional.of(o);
                            }
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            matcher = patternBlock.matcher(interfaces);
            if(matcher.matches())
            {
                for (Object block : blocks) {
                    try {
                        String c = block.getClass().getMethod("getColor").invoke(block).toString();
                        System.out.println("color: "+c);
                        if(color.equals(c)) {
                            return Optional.of(block);
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            return Optional.empty();
        }
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