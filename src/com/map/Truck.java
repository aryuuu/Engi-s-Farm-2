package com.map;

/**
 * file Truck.java
 * <p>
 *     Kelas Truck merepresentasikan Truk
 * </p>
 *
 * @author Naufal Zhafran Latif / 13517095
 *
 * @version 1.0
 *`
 * @since 2019-04-15
 */

public class Truck extends Cell {

    /**
     * Konstruktor dari kelas Truck
     *
     * @param x posisi x dari well
     * @param y posisi y dari well
     */
    public Truck(int x, int y) {
        super(x, y, "Truck");
    }

    /**
     * Method yang akan print Land ke CLI
     *
     */
    @Override
    public void print() {
        System.out.println("T");
    }

}
