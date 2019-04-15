package com.animal;

/**
 * file Chicken.java
 * <p>
 *     Kelas yang menggambarkan ayam pada farm.
 *     Ayam tinggal di Coop
 *     Ayam berbicara "Kukuruyuk" pada diajak bicara
 *     Ayam dapat diinteraksi (menghasilkan telur) dan dibunuh (menghasilkan daging)
 * </p>
 *
 * @author Jan Meyer Saragih / 13517131
 *
 * @version 1.0
 *`
 * @since 2019-04-14
 */
public class Chicken extends Animal implements EggProducingAnimal, MeatProducingAnimal
{
    // Atribut

    /**
     * Tipe dari animal tersebut
     */
    private final String TYPE = "Chicken";

    /**
     * Habitat dari animal tersebut
     */
    private final String HABITAT = "Coop";

    /**
     * Suara dari animal tersebut
     */
    private final String SOUND = "Kukuruyuukkkk";


    // Method

    // Kontruktor

    /**
     * Konstruktor dari kelas animal Chicken
     *
     * @param x baris dari animal tersebut
     * @param y kolom dari animal tersebut
     */
    public Chicken (int x, int y)
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
            System.out.print("a");
        }
        else
        {
            System.out.print("A");
        }
    }

    /**
     * Mengembalikan produk hasil interaksi (telur) dari binatang tersebut
     *
     * @return telur dari bintang tersebut
     */
    public String interactProduct()
    {
        return "ChickenEgg";
    }

    /**
     * Mengembalikan produk hasil kill (daging) dari binatang tersebut
     *
     * @return daging dari bintang tersebut
     */
    public String killProduct()
    {
        return "ChickenMeat";
    }
}