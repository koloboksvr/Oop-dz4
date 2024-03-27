package ru.geekbrains.oop.lesson4.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Program {

    /**
     Домашняя работа, задача:
     ========================

     a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
     b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
     поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
     c. Для хранения фруктов внутри коробки можно использовать ArrayList;
     d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
     вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
     e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
     подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
     Можно сравнивать коробки с яблоками и апельсинами;
     f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
     Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
     Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
     g. Не забываем про метод добавления фрукта в коробку.
     */

    // public static void main(String[] args) {


    // }
    
    public static void boxesInfo(ArrayList<Box> boxes, int number){
        int count = number;
        for (Box x : boxes) {
            System.err.print("Информация по коробке N" + count + ": ");
            System.err.println(x);
            count++;
        }
        System.out.println();
    }


    public static void grabFromConv(ArrayList<Fruit> conveyor, Box box){
        for (int index = 0; index < conveyor.size(); index++) {
            float pre = box.boxWeight();
            box.addfruit(conveyor.get(index));
            if (box.boxWeight() != pre){
            conveyor.remove(index);
            index--;
            }
        }
    }

    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();
        Box box4 = new Box();
        int fruitNumber = 15;

        ArrayList<Box> boxArray = new ArrayList<>(Arrays.asList(box1, box2, box3, box4));
        ArrayList<Fruit> conveyor1 = Conveyor.generateFruitArray(fruitNumber);
        ArrayList<Fruit> conveyor2 = Conveyor.generateFruitArray(fruitNumber);
        boxesInfo(boxArray, 1);

        System.out.println("На конвейере №1 следующие фрукты: "  + (conveyor1));
        System.out.println("____________");
        System.out.println("На конвейере №2 следующие фрукты: "  + (conveyor2));
        System.out.println("____________");

        System.out.println("Собираем фрукты с 1-го конвейера в первую коробку");
        grabFromConv(conveyor1, box1);

        System.out.println("Собираем фрукты с 1-го конвейера во вторую коробку");    
        grabFromConv(conveyor1, box2);

        System.out.println("Собираем фрукты со 2-го конвейера в третью коробку");    
        grabFromConv(conveyor2, box3);

        System.out.println("Собираем фрукты со 2-го конвейера в четвертую коробку");    
        grabFromConv(conveyor2, box4);
        System.out.println("____________");

        boxesInfo(boxArray, 1);
        System.out.println("____________");

        System.out.println("Пробуем пересыпать фрукты из первой коробки в третью:");
        box1.pourTo(box3);     
        System.out.println("Пробуем пересыпать фрукты из первой коробки в четвертую:");
        box1.pourTo(box4);  
        System.out.println("Пробуем пересыпать фрукты из второй коробки в третью:");
        box2.pourTo(box3);     
        System.out.println("Пробуем пересыпать фрукты из второй коробки в четвертую:");
        box2.pourTo(box4);  
        System.out.println("____________");

        boxesInfo(boxArray, 1);

        System.out.println("Сравниваем вес третьей и четвертой коробки:");
        System.out.println(box3.compare(box4));
        System.out.println("____________");

        System.out.println("Насыпаем в пятую и шестую коробку фрукты разного вида, но одного веса для провреки");
        Apple apple1 = new Apple();
        Orange orange1 = new Orange();
        Box box5 = new Box();
        Box box6 = new Box();
        ArrayList<Box> boxArraycheck = new ArrayList<>(Arrays.asList(box5, box6));
        for (int index = 0; index < 3; index++) box5.addfruit(apple1);
        for (int index = 0; index < 2; index++) box6.addfruit(orange1);
        
        boxesInfo(boxArraycheck, 5);
        System.out.println("Сравниваем вес пятой и шестой коробки:");
        System.out.println(box5.compare(box6));

    }

}


