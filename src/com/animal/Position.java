package com.animal;


/**
 * Position.java
 * <p>
 *     Kelas yang menggambarkan posisi dari sebuah objek di farm dengan menggambarkan letak baris dan kolom dari objek tersebut
 * </p>
 *
 * @author Jan Meyer Saragih / 13517131
 *
 * @version 1.0
 *
 * @since 2019-04-13
 */
public class Position
{
    // Atribut

    /**
     * Posisi baris dari Position (dimulai dari angka 0)
     */
    private int row;

    /**
     * Posisi kolom dari Position (dimulai dari angka 0)
     */
    private int col;

    // Method

    // Kontruktor

    /**
     * Konstruktor dari kelas Position
     *
     * @param x baris dari position tersebut
     * @param y kolom dari position tersebut
     */
    public Position (int x, int y)
    {
        this.row = x;
        this.col = y;
    }

    // Getter - setter

    /**
     * Getter atribut row dari Position
     *
     * @return baris dari position tersebut
     */
    public int getRow()
    {
        return this.row;
    }

    /**
     * Getter atribut col dari Position
     *
     * @return kolom dari position tersebut
     */
    public int getColumn()
    {
        return this.col;
    }

    /**
     * Setter atribut row dari position
     *
     * @param row - baris dari position tersebut
     */
    public void setRow (int row)
    {
        this.row = row;
    }

    /**
     * Setter atribut col dari position
     *
     * @param col - kolom dari position tersebut
     */
    public void setColumn (int col)
    {
        this.col = col;
    }

    /**
     * Memastikan bahwa kedua posisi itu sama
     *
     * @param p - Position yang mau dibandingkan dengan objek
     *
     * @return True jika kedua posisi sama, False jika kebalikannya
     */
    public boolean equals (Position p)
    {
        return (this.row == p.row && this.col == p.col);
    }
}