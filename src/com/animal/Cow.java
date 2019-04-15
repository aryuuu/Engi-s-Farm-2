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
public class Cow extends Animal implements MilkProducingAnimal, MeatProducingAnimal
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
     * Method yang menandakan bahwa animal tersebut dapat diinteraksikan
     *
     * @return True jika animal tersebut menghasilkan produk hasil interaksi, False jika tidak
     */
    public boolean canBeInteracted()
    {
        return true;
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
            System.out.print("c");
        }
        else
        {
            System.out.print("C");
        }
    }

    /**
     * Mengembalikan produk hasil interaksi (susu) dari binatang tersebut
     *
     * @return susu dari bintang tersebut
     */
    public String interactProduct()
    {
        return "CowMilk";
    }

    /**
     * Mengembalikan produk hasil kill (daging) dari binatang tersebut
     *
     * @return daging dari bintang tersebut
     */
    public String killProduct()
    {
        return "CowMeat";
    }
}