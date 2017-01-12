package com.commit451.horizontalpicker.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Nice custom object!
 */
public class Fruit {

    public static List<Fruit> getFruits() {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Apple"));
        fruits.add(new Fruit("Banana"));
        fruits.add(new Fruit("Orange"));
        fruits.add(new Fruit("Kiwi"));
        fruits.add(new Fruit("Tomato"));
        fruits.add(new Fruit("Grape"));
        fruits.add(new Fruit("Pineapple"));
        return fruits;
    }

    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
