package com.animal;

/**
 * file Cow.java
 * <p>
 *     Kelas yang menggambarkan sapi pada farm.
 *     Sapi tinggal di Barn
 *     Sapi berbicara "Moooo" pada diajak bicara
 *     Sapi dapat diinteraksi (menghasilkan susu) dan dibunuh (menghasilkan daging)
 * </p>
 *
 * @author Jan Meyer Saragih / 13517131
 *
 * @version 1.0
 *`
 * @since 2019-04-14
 */
public class Cow extends Animal
{
    // Atribut

    /**
     * Tipe dari animal tersebut
     */
    private final String TYPE = "Cow";

    /**
     * Habitat dari animal tersebut
     */
    private final String HABITAT = "Barn";

    /**
     * Suara dari animal tersebut
     */
    private final String SOUND = "Moooooo";


    // Method

    // Kontruktor

    /**
     * Konstruktor dari kelas animal Cow
     *
     * @param x baris dari animal tersebut
     * @param y kolom dari animal tersebut
     */
    public Cow (int x, int y)
    {
        super(x, y);
    }

    // Method-method lain

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
            System.out.print("c");
        }
        else
        {
            System.out.print("C");
        }
    }

    /**
     * Menyatakan apabila animal tersebut merupakan produsen dari egg
     *
     * @return animal dapat menghasilkan telur
     */
    public boolean canProduceEgg()
    {
        return false;
    }

    /**
     * Mengembalikan produk hasil interaksi (telur) dari binatang tersebut
     *
     * @return telur dari bintang tersebut
     */
    public String eggProduct()
    {
        return "none";
    }

    /**
     * Menyatakan apabila animal tersebut menghasilkan daging apabila dibunuh
     *
     * @return animal dapat menghasilkan daging
     */
    public boolean canProduceMeat()
    {
        return true;
    }

    /**
     * Mengembalikan produk hasil kill (daging) dari binatang tersebut
     *
     * @return daging dari bintang tersebut
     */
    public String meatProduct()
    {
        return "CowMeat";
    }

    /**
     * Menyatakan apabila animal yang dimaksud dapat menghasilkan susu
     *
     * @return animal dapat menghasilkan susu
     */
    public boolean canProduceMilk()
    {
        return true;
    }

    /**
     * Mengembalikan produk hasil interaksi (susu) dari binatang tersebut
     *
     * @return susu dari bintang tersebut
     */
    public String milkProduct()
    {
        return "CowMilk";
    }
}