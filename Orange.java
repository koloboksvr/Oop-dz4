package ru.geekbrains.oop.lesson4.homework;

public class Orange extends Fruit{
    public Orange() {
        super(1.5f);
    }
    public static Orange create() {
        return new Orange();
     }

     public String toString(){
        return String.format("%s: %.2f", "Апельсин", this.getWeight());
    }

}
