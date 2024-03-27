package ru.geekbrains.oop.lesson4.homework;


import java.util.Random;

import javax.sound.sampled.AudioFileFormat.Type;

import java.util.ArrayList;

public class Conveyor {
    private static Random random = new Random();


   public Conveyor() {
}

    public static Fruit generateFruit() {
       int fruitType = random.nextInt(2);
 
       if (fruitType == 0) {
          return Apple.create();
       } else {
          return Orange.create();
       }
    }

 
    public static ArrayList<Fruit> generateFruitArray(int count) {
       //Fruit[] converyor = new Fruit[count];
       ArrayList<Fruit> conveyor = new ArrayList<>();
 
       for(int i = 0; i < count; ++i) {
         conveyor.add(generateFruit());
       }
 
       return conveyor;

    }


 }