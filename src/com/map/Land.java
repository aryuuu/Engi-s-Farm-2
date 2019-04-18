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
    private String category;

    /**
     * Konstruktor dari kelas Land
     *
     * @param x posisi x dari Land
     * @param y posisi y dari Land
     * @param isGrass apakah ada grass atau tidak
     * @param category kategori dari Land(Coop, Barn,Grassland)
     */
    public Land(int x, int y, boolean isGrass, String category) {
        super(x, y, "Land");
        this.isGrass = isGrass;
        this.category = category;
    }

    /**
     * Getter atribut isGrass menandakan apakah ada Grass atau tidak
     *
     * @return isGrass menandakan apakah ada Grass atau tidak
     */
    @Override
    public boolean isGrass() {
        return isGrass;
    }

    /**
     * Setter atribut isGrass menandakan apakah ada Grass atau tidak
     *
     * @param isGrass menandakan apakah ada Grass atau tidak
     */
    @Override
    public void setGrass(boolean grass) {
        isGrass = grass;
    }

    /**
     * Getter atribut category menandakan kategori dari Land
     *
     * @return isGrass menandakan kategori dari Land
     */
    public String getCategory() {
        return category;
    }

    /**
     * Method yang akan print Land ke CLI
     *
     */
    @Override
    public void print() {

        if(this.category == "Coop"){
            if (this.isGrass) {
                System.out.print("*");
            } else {
                System.out.print("o");
            }


        }else if(this.category == "Barn"){
            if (this.isGrass) {
                System.out.print("@");
            } else {
                System.out.print("x");
            }

        }else if(this.category == "Grassland"){
            if (this.isGrass) {
                System.out.print("#");
            } else {
                System.out.print("-");
            }
        }


    }
}
