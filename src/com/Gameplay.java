package com;

import com.animal.AnimalContainer;
import com.map.Map;
import com.player.Player;

/**
 * file Gameplay.java
 */
public class Gameplay
{
    // Atribut

    private AnimalContainer farmAnimals;

    private Map farmMap;

    private Player player;

    // Method

    public Gameplay (String filename1, String filename2)
    {
        farmMap = new Map(filename1);
        farmAnimals = new AnimalContainer(filename2);
        player = new Player();
    }

    public void showGameplay()
    {
        System.out.println();
        for (int i = 0; i < farmMap.getMaxRow(); i++)
        {
            for (int j = 0; j < farmMap.getMaxCol(); j++)
            {
                if (player.getX() == i && player.getY() == j)
                {
                    System.out.print("P");
                }
                else if (farmAnimals.animalOn(i, j) != -1)
                {
                    int x = farmAnimals.animalOn(i, j);
                    System.out.print(farmAnimals.getAnimal(x));
                }
                else
                {
                    farmMap.getCell(i, j).getLegend();
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
        player.print();
    }

    public void moveUp()
    {
        if (farmMap.isValidPos(player.getX() - 1, player.getY()) && farmAnimals.animalOn(player.getX() - 1, player.getY()) == -1)
        {
            System.out.println("Animal moved up");
            player.setX(player.getX() - 1);
        }
        else
        {
            System.out.println("Invalid move");
        }
    }

    public void moveDown()
    {
        if (farmMap.isValidPos(player.getX() + 1, player.getY()) && farmAnimals.animalOn(player.getX() + 1, player.getY()) == -1)
        {
            System.out.println("Animal moved down");
            player.setX(player.getX() + 1);
        }
        else
        {
            System.out.println("Invalid move");
        }
    }

    public void moveLeft()
    {
        if (farmMap.isValidPos(player.getX(), player.getY() - 1) && farmAnimals.animalOn(player.getX(), player.getY() - 1) == -1)
        {
            System.out.println("Animal moved left");
            player.setY(player.getY() - 1);
        }
        else
        {
            System.out.println("Invalid move");
        }
    }

    public void moveRight()
    {
        if (farmMap.isValidPos(player.getX(), player.getY() + 1) && farmAnimals.animalOn(player.getX(), player.getY() + 1) == -1)
        {
            System.out.println("Animal moved right");
            player.setY(player.getY() + 1);
        }
        else
        {
            System.out.println("Invalid move");
        }
    }

    public void grow()
    {
        if (farmMap.getCell(player.getX(), player.getY()).isGrass())
        {
            if (player.getWater() > 0)
            {
                System.out.println("Watering the land...");
                farmMap.getCell(player.getX(), player.getY()).setGrass(true);
                player.reduceWater();
            }
            else
            {
                System.out.println("Not enough water");
            }
        }
        else
        {
            System.out.println("No need for watering");
        }
    }
    
    public void talk()
    {

    }

    public void interact()
    {

    }

    public void kill()
    {
        
    }

    public void allAnimalMove()
    {

    }

    public void allAnimalEatGrass()
    {

    }

    public void everyTurn()
    {
        allAnimalMove();
        farmAnimals.allAnimalHungrier();
        allAnimalEatGrass();
        farmAnimals.killDeads();
    }
}