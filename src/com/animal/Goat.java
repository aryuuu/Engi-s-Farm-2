package com.animal;

/**
 * file Goat.java
 * <p>
 *     Kelas yang menggambarkan kambing pada farm.
 *     Kambing tinggal di Barn
 *     Kambing berbicara "Mbeeeeek" pada diajak bicara
 *     Kambing tidak dapat diinteraksi dan tidak dapat dibunuh
 * </p>
 *
 * @author Jan Meyer Saragih / 13517131
 *
 * @version 1.0
 *`
 * @since 2019-04-14
 */
public class Goat extends Animal
{
    // Atribut

    /**
     * Tipe dari animal tersebut
     */
    private final String TYPE = "Goat";

    /**
     * Habitat dari animal tersebut
     */
    private final String HABITAT = "Barn";

    /**
     * Suara dari animal tersebut
     */
    private final String SOUND = "Mbeeeeeeeeeeekk";


    // Method

    // Kontruktor

    /**
     * Konstruktor dari kelas animal Goat
     *
     * @param x baris dari animal tersebut
     * @param y kolom dari animal tersebut
     */
    public Goat (int x, int y)
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
            System.out.print("g");
        }
        else
        {
            System.out.print("G");
        }
    }
}