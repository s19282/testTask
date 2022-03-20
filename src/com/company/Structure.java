package com.company;

import java.util.List;
import java.util.Optional;

interface Structure {

    Optional findBlockByColor(String color);
    List findBlocksByMaterial(String material);
    int count();
}