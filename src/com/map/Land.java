package com.map;

public class Land extends Cell {
    private boolean isGrass;

    public Land(int x, int y, boolean isGrass) {
        super(x, y, "Land");
        this.isGrass = isGrass;
    }

    public boolean isGrass() {
        return isGrass;
    }

    public void setGrass(boolean grass) {
        isGrass = grass;
    }

    @Override
    public void print() {
        if (this.isGrass) {
            System.out.println("^");
        } else {
            System.out.println("-");
        }
    }
}
