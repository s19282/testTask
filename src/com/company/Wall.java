package com.company;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
        if (!blocks.isEmpty()) {
            String interfaces = Arrays.toString(blocks.get(0).getClass().getInterfaces());
            System.out.println(interfaces);
            Pattern patternBlock = Pattern.compile(".+interface com\\.company\\.Block.+");
            Pattern patternCompositeBlock = Pattern.compile(".+interface com\\.company\\.CompositeBlock.+");
            Matcher matcher = patternCompositeBlock.matcher(interfaces);
            if (matcher.matches()) {
                for (Object block : blocks) {
                    try {
                        List getBlocks = (List) block.getClass().getMethod("getBlocks").invoke(block);
                        for (Object o : getBlocks) {
                            String c = o.getClass().getMethod("getColor").invoke(o).toString();
                            if (color.equals(c)) {
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
            if (matcher.matches()) {
                for (Object block : blocks) {
                    try {
                        String c = block.getClass().getMethod("getColor").invoke(block).toString();
                        System.out.println("color: " + c);
                        if (color.equals(c)) {
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
        }
        return Optional.empty();
    }

    @Override
    public List findBlocksByMaterial(String material) {
        List matchMaterialBlocks = new ArrayList();
        if (!blocks.isEmpty()) {
            String interfaces = Arrays.toString(blocks.get(0).getClass().getInterfaces());
            System.out.println(interfaces);
            Pattern patternBlock = Pattern.compile(".+interface com\\.company\\.Block.+");
            Pattern patternCompositeBlock = Pattern.compile(".+interface com\\.company\\.CompositeBlock.+");
            Matcher matcher = patternCompositeBlock.matcher(interfaces);
            if (matcher.matches()) {
                matchMaterialBlocks.clear();
                for (Object block : blocks) {
                    try {
                        List getBlocks = (List) block.getClass().getMethod("getBlocks").invoke(block);
                        for (Object o : getBlocks) {
                            String m = o.getClass().getMethod("getMaterial").invoke(o).toString();
                            if (material.equals(m)) {
                                matchMaterialBlocks.add(o);
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
            if (matcher.matches()) {
                matchMaterialBlocks.clear();
                for (Object block : blocks) {
                    try {
                        String m = block.getClass().getMethod("getMaterial").invoke(block).toString();
                        System.out.println("color: " + m);
                        if (material.equals(m)) {
                            matchMaterialBlocks.add(block);
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
        }
        return matchMaterialBlocks;
    }

    @Override
    public int count() {
        int counter = 0;
        if (!blocks.isEmpty()) {
            String interfaces = Arrays.toString(blocks.get(0).getClass().getInterfaces());
            System.out.println(interfaces);
            Pattern patternBlock = Pattern.compile(".+interface com\\.company\\.Block.+");
            Pattern patternCompositeBlock = Pattern.compile(".+interface com\\.company\\.CompositeBlock.+");
            Matcher matcher = patternCompositeBlock.matcher(interfaces);
            if (matcher.matches()) {
                for (Object block : blocks) {
                    try {
                        List getBlocks = (List) block.getClass().getMethod("getBlocks").invoke(block);
                        counter += getBlocks.size();
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            matcher = patternBlock.matcher(interfaces);
            if (matcher.matches()) {
                counter = blocks.size();
            }
        }
        return counter;
    }

    private String getInterface() {
        String interfaces = Arrays.toString(blocks.get(0).getClass().getInterfaces());
        if (interfaces.contains("interface com\\.company\\.CompositeBlock")) {
            return "CompositeBlock";
        } else if (interfaces.contains("interface com\\.company\\.Block")) {
            return "Block";
        } else {
            return null;
        }
    }
}