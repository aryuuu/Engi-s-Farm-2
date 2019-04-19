package com.animal;

/**
 * file Horse.java
 * <p>
 *     Kelas yang menggambarkan kuda pada farm.
 *     Kuda tinggal di Grassland
 *     Kuda berbicara "Ngiiihhhh" pada diajak bicara
 *     Kuda dapat diinteraksi (menghasilkan susu) namun tidak dapat dibunuh
 * </p>
 *
 * @author Jan Meyer Saragih / 13517131
 *
 * @version 1.0
 *`
 * @since 2019-04-14
 */
public class Horse extends Animal
{
    // Atribut

    /**
     * Tipe dari animal tersebut
     */
    private final String TYPE = "Horse";

    /**
     * Habitat dari animal tersebut
     */
    private final String HABITAT = "Grassland";

    /**
     * Suara dari animal tersebut
     */
    private final String SOUND = "Ngiiiihhhh";


    // Method

    // Kontruktor

    /**
     * Konstruktor dari kelas animal Horse
     *
     * @param x baris dari animal tersebut
     * @param y kolom dari animal tersebut
     */
    public Horse (int x, int y)
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
            System.out.print("h");
        }
        else
        {
            System.out.print("H");
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
     * Menyatakn apabila animal tersebut menghasilkan daging apabila dibunuh
     *
     * @return animal dapat menghasilkan daging
     */
    public boolean canProduceMeat()
    {
        return false;
    }

    /**
     * Mengembalikan produk hasil kill (daging) dari binatang tersebut
     *
     * @return daging dari bintang tersebut
     */
    public String meatProduct()
    {
        return "none";
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
        return "HorseMilk";
    }
}