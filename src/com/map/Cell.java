package com.map;


/**
 * file Cell.java
 * <p>
 *     Kelas Abstrak untuk mengurus Cell pada Map
 * </p>
 *
 * @author Naufal Zhafran Latif / 13517095
 *
 * @version 1.0
 *`
 * @since 2019-04-15
 */



public abstract class Cell {

    /**
     * Posisi x dari Cell
     */
    protected int x;

    /**
     * Posisi y dari Cell
     */
    protected int y;

    /**
     * Legend/jenis dari cell
     */
    protected String legend;


    /**
     * Konstruktor dari kelas Cell
     *
     * @param x posisi x dari cell
     * @param y posisi y dari cell
     * @param legend jenis cell
     */
    public Cell(int x, int y, String legend) {
        this.x = x;
        this.y = y;
        this.legend = legend;
    }

    /**
     * Getter atribut lokasi x dari cell
     *
     * @return lokasi x dari animal tersebut
     */
    public int getX() {
        return x;
    }

    /**
     * Getter atribut lokasi y dari cell
     *
     * @return lokasi y dari animal tersebut
     */
    public int getY() {
        return y;
    }

    /**
     * Getter atribut legend/jenis dari cell
     *
     * @return legend/jenis dari cell
     */
    public String getLegend() {
        return legend;
    }

    /**
     * Setter atribut lokasi x dari animal
     *
     * @param lokasi x dari animal
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Setter atribut lokasi y dari animal
     *
     * @param lokasi y dari animal
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Setter atribut legend/jenis cell
     *
     * @param legend/jenis cell
     */
    public void setLegend(String legend) {
        this.legend = legend;
    }

    /**
     * Method yang akan print cell ke CLI
     *
     */
    abstract public void print();
}
