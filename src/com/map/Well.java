package com.map;

public class Well extends Cell {
    public Well(int x, int y) {
        super(x, y, "Well");
    }

    @Override
    public void print() {
        System.out.println("W");
    }
}
