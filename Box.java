package ru.geekbrains.oop.lesson4.homework;

import java.util.ArrayList;

public class Box<T extends Fruit>  {
    private ArrayList<T> fruits;
    private String boxType;




    public Box() {
        this.fruits = new ArrayList<T>();
        this.boxType = "без фруктов";
    }

    public String getBoxType() {
        return boxType;
    }

    public void addfruit (T fruit) {
        //check(fruit);
        if (this.fruits.size() == 0) {
            if (fruit instanceof Apple) boxType = "с яблоками";
            else boxType = "с апельсинами";
        }
        if( this.fruits.size() == 0 || fruit instanceof Apple == fruits.get(0) instanceof Apple){
            this.fruits.add(fruit);
        }
        else; 
    }

    public String toString(){
        return String.format("Коробка %s, вес: %.2f", this.boxType, boxWeight());
    }
  

    public float boxWeight(){
        if (fruits.size() == 0) {
            return 0;
        } else return fruits.size()* fruits.get(0).getWeight();
    }

    public void pourTo(Box otherBox){
        if (this.boxType == otherBox.getBoxType()) {
            for (int index = 0; this.fruits.size() != 0;) {
                otherBox.addfruit(this.fruits.remove(index));
            }
            System.out.println("Фрукты пересыпаны\n");
        } else System.out.println("Нельзя пересыпать из коробки " + this.getBoxType() + " в коробку " + otherBox.getBoxType() +"\n");
    }

    public boolean compare(Box oterBox){
        if (this.boxWeight() == oterBox.boxWeight()) return true;
        else return false;
    }
}
