// Changed
package com;

import com.animal.AnimalContainer;
import com.animal.Position;
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

    public AnimalContainer getFarmAnimals() {
        return farmAnimals;
    }

    public void setFarmAnimals(AnimalContainer farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    public Map getFarmMap() {
        return farmMap;
    }

    public void setFarmMap(Map farmMap) {
        this.farmMap = farmMap;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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
                    farmAnimals.getAnimal(x).printTile();
                }
                else
                {
                    farmMap.getCell(i, j).print();
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
        if (!farmMap.getCell(player.getX(), player.getY()).isGrass())
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
        int i = farmAnimals.animalNear(player.getX(), player.getY());
        if (i != -1)
        {
            System.out.println("Animal found");
            System.out.println("Animal " + farmAnimals.getAnimal(i).animalType() + " says " + farmAnimals.getAnimal(i).animalSound());
        }
        else
        {
            System.out.println("No animal around");
        }
    }

    public void interact()
    {
        int num = farmAnimals.animalNear(player.getX(), player.getY());
        if (num != -1)
        {
            System.out.println("Animal found, type = " + farmAnimals.getAnimal(num).animalType());
            if (farmAnimals.getAnimal(num).canBeInteracted())
            {
                if (!farmAnimals.getAnimal(num).getHungry())
                {
                    System.out.println("Interact Product: " + farmAnimals.getAnimal(num).interactProduct());
                    player.addProduct(farmAnimals.getAnimal(num).interactProduct());
                    farmAnimals.getAnimal(num).setHungry(true);
                }
                else
                {
                    System.out.println("Can't be interacted. Animal is strill hungry");
                }
            }
            else
            {
                System.out.println("Animal can't be interacted. Because it's useless");
            }
            
        }
        else if (farmMap.isNear(player.getX(), player.getY(), "Well"))
        {
            System.out.println("Well here...");
            player.addWater();
        }
        else if (farmMap.isNear(player.getX(), player.getY(), "Truck"))
        {
            System.out.println("Truck here...");
            player.delProductAll();
        }
        else
        {
            System.out.println("Nothing can be interacted with");
        }
    }

    public void kill()
    {
        int num = farmAnimals.animalNear(player.getX(), player.getY());
        if (num != -1)
        {
            System.out.println("Animal found, type = " + farmAnimals.getAnimal(num).animalType());
            if (farmAnimals.getAnimal(num).canBeKilled())
            {
                System.out.println("Kill Product: " + farmAnimals.getAnimal(num).killProduct());
                player.addProduct(farmAnimals.getAnimal(num).killProduct());
                farmAnimals.removeAnimal(farmAnimals.getAnimal(num));
            }
            else
            {
                System.out.println("Animal can't be killed, because it's useless");
            }
        }
        else
        {
            System.out.println("No animal around");
        }
    }

    public void mix()
    {
        if (farmMap.isNear(player.getX(), player.getY(), "Mixer"))
        {
            System.out.println("Mixer here...");

            System.out.println("Mixing Buttermilk Chicken");
            player.addProduct("ButtermilkChicken");

            System.out.println("Mixing Omellete");
            player.addProduct("Omellete");

            System.out.println("Mixing Meatball");
            player.addProduct("Meatball");
        }
        else
        {
            System.out.println("No mixer around...");
        }
    }

    public void allAnimalMove()
    {
        for (int i = 0; i < farmAnimals.getNumAnimal(); i++)
        {
            Position temp = farmAnimals.getAnimal(i).randomMove();
            if (farmMap.isWithinArea(temp.getRow(), temp.getColumn()))
            {
                if (player.getX() != temp.getRow() && player.getY() != temp.getColumn() && farmAnimals.animalOn(temp.getRow(), temp.getColumn()) == -1 && farmMap.getCell(temp.getRow(), temp.getColumn()).getCategory().equals(farmAnimals.getAnimal(i).animalHabitat()))
                {
                    farmAnimals.getAnimal(i).setLocation(temp.getRow(), temp.getColumn());
                }
            }
        }
    }

    public void allAnimalEatGrass()
    {
        for (int i = 0; i < farmAnimals.getNumAnimal(); i++)
        {
            if (farmAnimals.getAnimal(i).getHungry())
            {
                Position temp = farmAnimals.getAnimal(i).getLocation();
                if (farmMap.getCell(temp.getRow(), temp.getColumn()).isGrass())
                {
                    farmMap.getCell(temp.getRow(), temp.getColumn()).setGrass(false);
                    farmAnimals.getAnimal(i).animalHasEaten();
                }
            }
        }
    }

    public void everyTurn()
    {
        allAnimalMove();
        farmAnimals.allAnimalHungrier();
        allAnimalEatGrass();
        farmAnimals.killDeads();
    }
}