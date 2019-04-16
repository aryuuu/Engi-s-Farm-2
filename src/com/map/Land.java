package com.map;

/**
 * file Cell.java
 * <p>
 *     Kelas Land ya untuk merepresentasikan tanah
 * </p>
 *
 * @author Naufal Zhafran Latif / 13517095
 *
 * @version 1.0
 *`
 * @since 2019-04-15
 */



public class Land extends Cell {

    /**
     * Untuk menandakan apakah ada grass atau tidak pada sebuah tanah
     */
    private boolean isGrass;

    /**
     * Konstruktor dari kelas Land
     *
     * @param x posisi x dari Land
     * @param y posisi y dari Land
     * @param isGrass apakah ada grass atau tidak
     */
    public Land(int x, int y, boolean isGrass) {
        super(x, y, "Land");
        this.isGrass = isGrass;
    }

    /**
     * Getter atribut isGrass menandakan apakah ada Grass atau tidak
     *
     * @return isGrass menandakan apakah ada Grass atau tidak
     */
    public boolean isGrass() {
        return isGrass;
    }

    /**
     * Setter atribut isGrass menandakan apakah ada Grass atau tidak
     *
     * @param isGrass menandakan apakah ada Grass atau tidak
     */
    public void setGrass(boolean grass) {
        isGrass = grass;
    }


    /**
     * Method yang akan print Land ke CLI
     *
     */
    @Override
    public void print() {
        if (this.isGrass) {
            System.out.println("^");
        } else {
            System.out.println("-");
        }
    }
}
