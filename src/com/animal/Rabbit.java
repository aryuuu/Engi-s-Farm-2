package com.animal;

/**
 * file Rabbit.java
 * <p>
 *     Kelas yang menggambarkan kelinci pada farm.
 *     Kelinci tinggal di Grassland
 *     Kelinci berbicara "Krrr--Krrrr" pada diajak bicara
 *     Kelinci tidak dapat diinteraksi namun dapat dibunuh (menghasilkan daging)
 * </p>
 *
 * @author Jan Meyer Saragih / 13517131
 *
 * @version 1.0
 *`
 * @since 2019-04-14
 */
public class Rabbit extends Animal implements MeatProducingAnimal
{
    // Atribut

    /**
     * Tipe dari animal tersebut
     */
    private final String TYPE = "Rabbit";

    /**
     * Habitat dari animal tersebut
     */
    private final String HABITAT = "Grassland";

    /**
     * Suara dari animal tersebut
     */
    private final String SOUND = "Krrr--Krrrr";


    // Method

    // Kontruktor

    /**
     * Konstruktor dari kelas animal Rabbit
     *
     * @param x baris dari animal tersebut
     * @param y kolom dari animal tersebut
     */
    public Rabbit (int x, int y)
    {
        super(x, y);
    }

    // Method-method lain

    /**
     * Method yang menandakan bahwa animal tersebut dapat diinteraksikan
     *
     * @return True jika animal tersebut menghasilkan produk hasil interaksi, False jika tidak
     */
    public boolean canBeInteracted()
    {
        return false;
    }

    /**
     * Method yang menandakan bahwa animal tersebut dapat dibunuh
     *
     * @return True jika animal tersebut menghasilkan produk hasil kill, False jika tidak
     */
    public boolean canBeKilled()
    {
        return true;
    }

    /**
     * Method yang menandakan tipe dari animal tersebut
     * 
     * @return Jenis animal tersebut
     */
    public String animalType()
    {
        return TYPE;
    }

    /**
     * Method yang menandakan habitat dari animal tersebut
     * 
     * @return Habitat animal tersebut
     */
    public String animalHabitat()
    {
        return HABITAT;
    }

    /**
     * Method yang menandakan suara dari animal tersebut
     * 
     * @return Suara animal tersebut
     */
    public String animalSound()
    {
        return SOUND;
    }

    /**
     * Method yang melakukan print animal tersebut pada map
     */
    public void printTile()
    {
        if (getHungry())
        {
            System.out.print("r");
        }
        else
        {
            System.out.print("R");
        }
    }

    /**
     * Mengembalikan produk hasil kill (daging) dari binatang tersebut
     *
     * @return daging dari bintang tersebut
     */
    public String killProduct()
    {
        return "RabbitMeat";
    }
}