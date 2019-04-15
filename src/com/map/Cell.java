package com.map;

public abstract class Cell {

    protected int x;
    protected int y;
    protected String legend;

    public Cell(int x, int y, String legend) {
        this.x = x;
        this.y = y;
        this.legend = legend;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getLegend() {
        return legend;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    abstract public void print();
}
