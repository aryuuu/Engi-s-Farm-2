package com.map;

/**
 * file Well.java
 * <p>
 *     Kelas Well merepresentasikan Sumur
 * </p>
 *
 * @author Naufal Zhafran Latif / 13517095
 *
 * @version 1.0
 *`
 * @since 2019-04-15
 */

public class Well extends Cell {

    /**
     * Konstruktor dari kelas Well
     *
     * @param x posisi x dari well
     * @param y posisi y dari well
     */
    public Well(int x, int y) {
        super(x, y, "Well");
    }

    /**
     * Method yang akan print Land ke CLI
     *
     */
    @Override
    public void print() {
        System.out.print("W");
    }
}
