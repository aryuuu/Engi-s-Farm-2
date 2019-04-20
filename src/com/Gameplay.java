// Changed
package com;

import com.animal.AnimalContainer;
import com.animal.Position;
import com.map.Map;
import com.player.Player;

/**
 * file Gameplay.java
 *
 * <p>
 *     Menggambarkan class yang permainan, yang menyatukan player, map, dan animal
 * </p>
 *
 * @author Jan Meyer Saragih / 13517131
 *
 * @version 1.0
 *
 * @since 2019-04-18
 *
 */
public class Gameplay
{
    // Atribut

    /**
     * Menggambarkan semua animal yang terdapat dalam game tersebut
     */
    private AnimalContainer farmAnimals;

    /**
     * Menggambarkan peta dari peternakan tersebut
     */
    private Map farmMap;

    /**
     * Menggambarkan player yang memiliki farm tersebut
     */
    private Player player;

    // Method

    /**
     * Konstruktor dari kelas Gameplay
     * <p>
     *     Mennginstansiasi kelas AnimalContainer, Map, dan Player yang terdapat dalam game
     * </p>
     * @param filename1 - File dari peta pertanian
     * @param filename2 - File dari data setiap animal dalam farm
     */
    public Gameplay (String filename1, String filename2)
    {
        farmMap = new Map(filename1);
        farmAnimals = new AnimalContainer(filename2);
        player = new Player();
    }

    /**
     * Getter dari Farm Animal
     * @return Mengembalikan AnimalContainer dari farm tersebut
     */
    public AnimalContainer getFarmAnimals() {
        return farmAnimals;
    }

    /**
     * Setter dari Farm Animal
     * @param farmAnimals - AnimalContainer yang ingin diset dalam game ini
     */
    public void setFarmAnimals(AnimalContainer farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    /**
     * Getter dari Farm Map
     * @return Mengembalikan Map (peta pertanian) dari game tersebut
     */
    public Map getFarmMap() {
        return farmMap;
    }

    /**
     * Setter ari Farm Map
     * @param farmMap - Map (peta) yang ingin diset dalam game ini
     */
    public void setFarmMap(Map farmMap) {
        this.farmMap = farmMap;
    }

    /**
     * Getter dari Player
     * @return Mengembalikan Player yang berada dalam game
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Setter dari Player
     * @param player - Player yang berada dalam game ini
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Menampilkan gameplay melalui CLI (peta, animal, dan player)
     */
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

    /**
     * Menggerakkan player ke atas jika bisa
     */
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

    /**
     * Menggerakkan player ke bawah jika bisa
     */
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

    /**
     * Menggerakkan player ke kiri jika bisa
     */
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

    /**
     * Menggerakkan player ke kanan jika bisa
     */
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

    /**
     * Menumbuhkan rumput di tempat player berdiri
     * <p>
     *     Syarat: player berada di tanah yang tidak memiliki rumput dan memiliki air yang diambil dari well
     * </p>
     */
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

    /**
     * Player berbicara dengan animal dan dikeluarkan suara dari animal tersebut
     */
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

    /**
     * Player berinteraksi dengan animal, well, atau truck
     * <p>
     *     Jika player berada dekat animal, maka animal tersebut mengeluarkan interactProduct jika kenyang dan menjadi lapar.
     *     Jika player berinteraksi dengan well, player akan mendapatkan air
     *     Jika player berinteraksi dengan truck, player akan menjual semua isi inventorynya
     * </p>
     */
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

    /**
     * Player membunuh animal yang berada di dekatnya jika animal tersebut dapat dibunuh
     */
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

    /**
     * Player menggabungkan FarmProduct yang dimiliki dan membuat SideProduct jika mampu
     */
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

    /**
     * Semua animal bergerak secara acak. Lalu, divalidasi dengan tidak adanya player, facility, atau animal lain di daerah target
     */
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

    /**
     * Semua animal yang lapar dan berdiri di atas rumput, makan rumput dan menjadi kenyang
     */
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

    /**
     * Menggambarkan setiap
     */
    public void everyTurn()
    {
        allAnimalMove();
        farmAnimals.allAnimalHungrier();
        allAnimalEatGrass();
        farmAnimals.killDeads();
    }
}