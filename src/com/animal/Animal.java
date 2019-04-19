package com.animal;

import java.lang.Math;
import java.util.Random;

/**
 * file Animal.java
 * <p>
 *     Kelas yang menggambarkan setiap animal dalam farm. Dalam kelas ini, setiap animal digambarkan berdasarkan posisinya dan tipenya. Di mana tipenya menggambarkan class real dari animal yang dibuat dan posisinya menggambarkan posisi dari animal tersebut dalam farm
 * </p>
 *
 * @author Jan Meyer Saragih / 13517131
 *
 * @version 1.0
 *`
 * @since 2019-04-13
 */
public abstract class Animal implements EggProducingAnimal, MeatProducingAnimal, MilkProducingAnimal
{
    // Atribut

    /**
     * Angka maksimum dari counter kelaparan animal. Jika melampaui ini, maka animal mati
     */
    protected final int DEADCOUNTER = 50;

    /**
     * Posisi dari animal tersebut (memanfaatkan Position)
     */
    protected Position loc;

    /**
     * Menghitung tingkat kelaparan dari animal tersebut
     */
    protected int hungerCounter;

    /**
     * Menandakan apakah animal tersebut sedang lapar atau tidak
     */
    protected boolean hungry;



    // Method

    // Kontruktor

    /**
     * Konstruktor dari kelas animal
     *
     * @param x baris dari animal tersebut
     * @param y kolom dari animal tersebut
     */
    public Animal (int x, int y)
    {
        this.loc = new Position(x, y);
        hungerCounter = 0;
        hungry = true;
    }

    // Getter - setter

    /**
     * Getter atribut loc dari animal
     *
     * @return lokasi dari animal tersebut
     */
    public Position getLocation()
    {
        return this.loc;
    }

    /**
     * Getter atribut baris dari animal
     *
     * @return baris dari animal tersebut
     */
    public int getX()
    {
        return this.loc.getRow();
    }

    /**
     * Getter atribut kolom dari animal
     *
     * @return kolom dari animal tersebut
     */
    public int getY()
    {
        return this.loc.getColumn();
    }

    /**
     * Getter atribut hungerCounter dari animal
     *
     * @return counter kelaparan dari animal tersebut
     */
    public int getHungerCounter()
    {
        return this.hungerCounter;
    }

    /**
     * Getter atribut hungry dari animal
     *
     * @return state lapar dari animal tersebut
     */
    public boolean getHungry()
    {
        return this.hungry;
    }

    /**
     * Setter atribut lokasi dari animal
     *
     * @param row dari animal tersebut
     * @param col dari animal tersebut
     */
    public void setLocation (int row, int col)
    {
        this.loc.setRow(row);
        this.loc.setColumn(col);
    }

    /**
     * Setter atribut hungerCounter dari animal
     *
     * @param hc kelaparan dari animal tersebut
     */
    public void setHungerCounter (int hc)
    {
        this.hungerCounter = hc;
    }

    /**
     * Setter atribut hungry dari animal
     *
     * @param hungry state lapar dari animal tersebut
     */
    public void setHungry (boolean hungry)
    {
        this.hungry = hungry;
    }

    // Method-method lain

    /**
     * Method menandakan animal telah makan
     * <p>
     *     Animal akan memiliki counter kelaparan 0 dan status lapar menjadi false
     * </p>
     */
    public void animalHasEaten()
    {
        this.hungerCounter = 0;
        this.hungry = false;
    }

    /**
     * Method menandakan animal telah diinteraksikan dengan player, sehingga status lapar menjadi true
     */
    public void interacted()
    {
        this.hungry = true;
    }

    /**
     * Method menambahkan counter kelaparan dari animal
     */
    public void hungrier()
    {
        this.hungerCounter++;
    }

    /**
     * Method mengecek apakah animal tersebut layak mati atau tidak
     *
     * @return True jika hungerCounter lebih atau sama dengan DEADCOUNTER, False jika kebalikannya
     */
    public boolean isDead()
    {
        return (this.hungerCounter >= DEADCOUNTER);
    }

    /**
     * Method mengecek apakah animal berada pada posisi berikut
     *
     * @param x - baris Posisi
     * @param y - kolom Posisi
     *
     * @return True jika baris == x dan kolom == y, False jika kebalikannya
     */
    public boolean isPosition (int x, int y)
    {
        return (this.loc.getRow() == x && this.loc.getColumn() == y);
    }

    /**
     * Method mengecek apakah animal berada dekat sebuah posisi
     *
     * @param x - baris Posisi
     * @param y - kolom Posisi
     *
     * @return True jika animal berada di atas, bawah, kiri, atau kanan dari posisi di parameter, False jika kebalikannya
     */
    public boolean isNear (int x, int y)
    {
        boolean found = false;
        if (x == this.loc.getRow() && Math.abs(this.loc.getColumn() - y) == 1)
        {
            found = true;
        }
        else if (y == this.loc.getColumn() && Math.abs(this.loc.getRow() - x) == 1)
        {
            found = true;
        }
        return found;
    }

    /**
     * Method yang menggambarkan gerakan acak dari sebuah animal dari posisinya
     *
     * @return Posisi acak yang berada di atas, bawah, kiri, atau kanan relatif terhadap loc animal tersebut
     */
    public Position randomMove()
    {
        Random r = new Random();
        int randOut = r.nextInt(10) + 1;
        int randIn = 0;
        Position targetPos = new Position(0, 0);
        int x = this.loc.getRow();
        int y = this.loc.getColumn();

        for (int i = 0; i < randOut; i++)
        {
            randIn = r.nextInt(4) + 1;
        }

        switch (randIn) {
            case 1:
                targetPos.setRow(x);
                targetPos.setColumn(y - 1);
                break;
            case 2:
                targetPos.setRow(x);
                targetPos.setColumn(y + 1);
                break;
            case 3:
                targetPos.setRow(x - 1);
                targetPos.setColumn(y);
                break;
            case 4:
                targetPos.setRow(x + 1);
                targetPos.setColumn(y);
                break;
            default:
                assert false;
        }

        return targetPos;
    }

    /**
     * Method yang menandakan bahwa animal tersebut dapat diinteraksikan
     *
     * @return True jika animal tersebut menghasilkan produk hasil interaksi, False jika tidak
     */
    public boolean canBeInteracted()
    {
        return (canProduceEgg()||canProduceMilk());
    }

    /**
     * Method yang menandakan bahwa animal tersebut dapat dibunuh
     *
     * @return True jika animal tersebut menghasilkan produk hasil kill, False jika tidak
     */
    public boolean canBeKilled()
    {
        return canProduceMeat();
    }

    /**
     * Method yang memberikan hasil dari interact dengan animal tersebut. Mengembalikan "none" jika tidak ada
     *
     * @return Hasil interact dengan binatang tersebut
     */
    public String interactProduct()
    {
        if (this.canProduceEgg())
        {
            return eggProduct();
        }
        else if (this.canProduceMilk())
        {
            return milkProduct();
        }
        else
        {
            return "none";
        }
    }

    /**
     * Method yang memberikan hasil dari kill animal tersebut. Mengembalikan "none" jika tidak ada
     *
     * @return Hasil kill dengan binatang tersebut
     */
    public String killProduct()
    {
        if (this.canProduceMeat())
        {
            return meatProduct();
        }
        else
        {
            return "none";
        }
    }

    /**
     * Method yang menandakan tipe dari animal tersebut
     * 
     * @return Jenis animal tersebut
     */
    public abstract String animalType();

    /**
     * Method yang menandakan habitat dari animal tersebut
     * 
     * @return Habitat animal tersebut
     */
    public abstract String animalHabitat();

    /**
     * Method yang menandakan suara dari animal tersebut
     * 
     * @return Suara animal tersebut
     */
    public abstract String animalSound();

    /**
     * Method yang melakukan print animal tersebut pada map
     */
    public abstract void printTile();

    // Dummy method
}