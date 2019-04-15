package com.animal;

/**
 * file Duck.java
 * <p>
 *     Kelas yang menggambarkan bebek pada farm.
 *     Bebek tinggal di Coop
 *     Bebek berbicara "Kwek-kwek" pada diajak bicara
 *     Bebek dapat diinteraksi (menghasilkan telur) namun tidak dapat dibunuh
 * </p>
 *
 * @author Jan Meyer Saragih / 13517131
 *
 * @version 1.0
 *`
 * @since 2019-04-14
 */
public class Duck extends Animal implements EggProducingAnimal
{
    // Atribut

    /**
     * Tipe dari animal tersebut
     */
    private final String TYPE = "Duck";

    /**
     * Habitat dari animal tersebut
     */
    private final String HABITAT = "Coop";

    /**
     * Suara dari animal tersebut
     */
    private final String SOUND = "Kwek-kwek";


    // Method

    // Kontruktor

    /**
     * Konstruktor dari kelas animal Duck
     *
     * @param x baris dari animal tersebut
     * @param y kolom dari animal tersebut
     */
    public Duck (int x, int y)
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
        return false;
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
            System.out.print("d");
        }
        else
        {
            System.out.print("D");
        }
    }

    /**
     * Mengembalikan produk hasil interaksi (telur) dari binatang tersebut
     *
     * @return telur dari bintang tersebut
     */
    public String interactProduct()
    {
        return "DuckEgg";
    }
}