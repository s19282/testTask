package com.company;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
        if (!blocks.isEmpty() && getInterface().isPresent()) {
            switch (getInterface().get()) {
                case "CompositeBlock" -> {
                    for (Object block : blocks) {
                        List getBlocks = invokeCompositeBlockMethod(block, "getBlocks");
                        for (Object o : getBlocks) {
                            String c = invokeBlockMethod(o, "getColor");
                            if (color.equals(c)) {
                                return Optional.of(o);
                            }
                        }
                    }
                }
                case "Block" -> {
                    for (Object block : blocks) {
                        String c = invokeBlockMethod(block, "getColor");
                        if (color.equals(c)) {
                            return Optional.of(block);
                        }
                    }
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List findBlocksByMaterial(String material) {
        List matchMaterialBlocks = new ArrayList();
        if (!blocks.isEmpty() && getInterface().isPresent()) {
            switch (getInterface().get()) {
                case "CompositeBlock" -> {
                    for (Object block : blocks) {
                        List getBlocks = invokeCompositeBlockMethod(block, "getBlocks");
                        for (Object o : getBlocks) {
                            String m = invokeBlockMethod(o, "getMaterial");
                            if (material.equals(m)) {
                                matchMaterialBlocks.add(o);
                            }
                        }
                    }
                }
                case "Block" -> {
                    for (Object block : blocks) {
                        String m = invokeBlockMethod(block, "getMaterial");
                        if (material.equals(m)) {
                            matchMaterialBlocks.add(block);
                        }
                    }
                }
            }
        }
        return matchMaterialBlocks;
    }

    @Override
    public int count() {
        int counter = 0;
        if (!blocks.isEmpty() && getInterface().isPresent()) {
            switch (getInterface().get()) {
                case "CompositeBlock" -> {
                    for (Object block : blocks) {
                        List getBlocks = invokeCompositeBlockMethod(block, "getBlocks");
                        counter += getBlocks.size();
                    }
                }
                case "Block" -> counter = blocks.size();
            }
        }
        return counter;
    }

    private Optional<String> getInterface() {
        String interfaces = Arrays.toString(blocks.get(0).getClass().getInterfaces());
        if (interfaces.contains("interface com.company.CompositeBlock")) {
            return Optional.of("CompositeBlock");
        } else if (interfaces.contains("interface com.company.Block")) {
            return Optional.of("Block");
        } else {
            return Optional.empty();
        }
    }

    private String invokeBlockMethod(Object object, String methodName) {
        String value = "";
        try {
            value = object.getClass().getMethod(methodName).invoke(object).toString();
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return value;
    }

    private List invokeCompositeBlockMethod(Object object, String methodName) {
        List list = new ArrayList();
        try {
            list = (List) object.getClass().getMethod(methodName).invoke(object);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return list;
    }
}