package com.animal;

import java.util.Scanner;

// Tipe komentar di sini jangan ditiru
// Hanya tester class Chicken
// CARA KOMENTAR TIDAK BENAR

public class ChickenTest
{
    public static void main (String[] args)
    {
        // Create the chicken
        Chicken test = new Chicken(1, 2);
        int choice = 0;

        Scanner in = new Scanner(System.in);
        int x, y, hc, h;
        Position temp;

        System.out.println("Tester dari class Chicken");
        System.out.println("Chicken berada di posisi (1, 2)");

        while (choice != -1)
        {
            System.out.println("Pilihan Test");
            System.out.println("1. getLocation");
            System.out.println("2. getHungerCounter");
            System.out.println("3. getHungry");
            System.out.println("4. setLocation");
            System.out.println("5. setHungerCounter");
            System.out.println("6. setHungry");
            System.out.println("7. animalHasEaten");
            System.out.println("8. interacted");
            System.out.println("9. hungrier");
            System.out.println("10. isDead");
            System.out.println("11. isPosition");
            System.out.println("12. isNear");
            System.out.println("13, randomMove");
            System.out.println("14. canBeInteracted");
            System.out.println("15. canBeKilled");
            System.out.println("16. animalType");
            System.out.println("17. animalHabitat");
            System.out.println("18. animalSound");
            System.out.println("19. printTile");
            System.out.println("20. interactProduct");
            System.out.println("21. killProduct");
            System.out.println("-1. Exit");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Location: (" + test.getLocation().getRow() + "," + test.getLocation().getColumn() + ")");
                    break;
                case 2:
                    System.out.println("Hunger Counter: " + test.getHungerCounter());
                    break;
                case 3:
                    System.out.println("Hungry state: " + test.getHungry());
                    break;
                case 4:
                    System.out.print("Masukkan row: ");
                    x = in.nextInt();
                    System.out.print("Masukkan column: ");
                    y = in.nextInt();
                    test.setLocation(x, y);
                    break;
                case 5:
                    System.out.print("Masukkan nilai hungerCounter: ");
                    hc = in.nextInt();
                    test.setHungerCounter(hc);
                    break;
                case 6:
                    System.out.print("Masukkan nilai (0 (false) / 1 (true))");
                    h = in.nextInt();
                    if (h == 0)
                    {
                        test.setHungry(false);
                    }
                    else if (h == 1)
                    {
                        test.setHungry(true);
                    }
                    else
                    {
                        System.out.println("Invalid input");
                    }
                    break;
                case 7:
                    test.animalHasEaten();
                    break;
                case 8:
                    test.interacted();
                    break;
                case 9:
                    test.hungrier();
                    break;
                case 10:
                    System.out.println("Test is Dead: " + test.isDead());
                    break;
                case 11:
                    System.out.print("Masukkan row: ");
                    x = in.nextInt();
                    System.out.print("Masukkan column: ");
                    y = in.nextInt();
                    System.out.println("Test in position: " + test.isPosition(x, y));
                    break;
                case 12:
                    System.out.print("Masukkan row: ");
                    x = in.nextInt();
                    System.out.print("Masukkan column: ");
                    y = in.nextInt();
                    System.out.println("Test near position: " + test.isNear(x, y));
                    break;
                case 13:
                    temp = test.randomMove();
                    System.out.println("Next Location: (" + temp.getRow() + "," + temp.getColumn() + ")");
                    break;
                case 14:
                    System.out.println("Can be interacted: " + test.canBeInteracted());
                    break;
                case 15:
                    System.out.println("Can be killed: " + test.canBeKilled());
                    break;
                case 16:
                    System.out.println("Animal type: " + test.animalType());
                    break;
                case 17:
                    System.out.println("Animal habitat: " + test.animalHabitat());
                    break;
                case 18:
                    System.out.println("Animal sound: " + test.animalSound());
                    break;
                case 19:
                    test.printTile();
                    break;
                case 20:
                    System.out.println("Interact product: " + test.interactProduct());
                    break;
                case 21:
                    System.out.println("Kill product: " + test.killProduct());
                    break;
                case -1:
                    break;
                default:
                    assert false;
            }
            System.out.println();
        }

        System.out.println("Tester ends...");
        in.close();

    }
}