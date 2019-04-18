package com.map;

/**
 * file Truck.java
 * <p>
 *     Kelas Mixer merepresentasikan mixer
 * </p>
 *
 * @author Naufal Zhafran Latif / 13517095
 *
 * @version 1.0
 *`
 * @since 2019-04-15
 */

public class Mixer extends Cell {

    /**
     * Konstruktor dari kelas Mixer
     *
     * @param x posisi x dari mixer
     * @param y posisi y dari mixer
     */
    public Mixer(int x, int y) {
        super(x, y, "Mixer");
    }

    /**
     * Method yang akan print Land ke CLI
     *
     */
    @Override
    public void print() {
        System.out.print("M");
    }

}
