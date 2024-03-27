package ru.geekbrains.oop.lesson4.homework;

public class Apple extends Fruit {
    public Apple() {
        super(1f);
    }
    public static Apple create() {
        return new Apple();
     }

     public String toString(){
        return String.format("%s: %.2f", "Яблоко", this.getWeight());
    }

}
