package com.animal;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Tipe komentar di sini jangan ditiru
// Hanya tester class AnimalContainer
// CARA KOMENTAR TIDAK BENAR

public class AnimalContainerTest
{
    public static void main (String[] args)
    {
        AnimalContainer animal2 = new AnimalContainer("farmAnimals.txt");
        animal2.printAnimals();

        // Create the chicken
        Chicken test1 = new Chicken(1, 2);
        Cow test2 = new Cow(2, 3);
        Duck test3 = new Duck(3, 4);
        Goat test4 = new Goat(4, 5);
        Horse test5 = new Horse(5, 6);
        Rabbit test6 = new Rabbit(6, 7);
        AnimalContainer animals = new AnimalContainer();

        int choice = 0;

        Scanner in = new Scanner(System.in);
        int x, y, hc, h;
        Position temp;

        System.out.println("Tester dari class AnimalContainer");

        animals.addAnimal(test1);
        animals.addAnimal(test2);
        animals.addAnimal(test3);
        animals.addAnimal(test4);
        animals.addAnimal(test5);
        animals.addAnimal(test6);
        animals.printAnimals();
        System.out.println();
        animals.removeAnimal(test2);
        animals.removeAnimal(test5);
        animals.printAnimals();
        System.out.println("Near (2, 2): " + animals.animalNear(new Position(2, 2)));
        System.out.println("On (1, 2): " + animals.animalOn(new Position(1, 2)));
        System.out.println("Near (10, 10): " + animals.animalNear(new Position(10, 10)));
        System.out.println("On (3, 2): " + animals.animalOn(new Position(3, 2)));


        System.out.println("Tester ends...");
        in.close();

    }
}