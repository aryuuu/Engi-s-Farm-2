package com.player;
/**
 * file Omellete.java
 * <p>
 *     Kelas yang merepresentasikan produk yang didapat setelah player mengolah CowMilk dan ChickenEgg
 * </p>
 *
 * @author M Algah Fattah Illahi
 *
 * @version 1.0
 *`
 * @since 2019-04-13
 */
public class Omellete extends Product implements SideProduct{
	// Atribut
    /**
     *  Atribut yang merupakan jumlah dari bahan yang dibutuhkan untuk membuat omellete
     */
	private int nResep = 2;
	
    /**
     *  Atribut yang merupakan daftar nama dari produk yang dibutuhkan untuk membuat omellete
     */
	private String resep[] = {"CowMilk", "ChickenEgg"};
	
	// Getter
	/**
	 * getter dari nResep
	 * @return nresep yang merupakan jumlah bahan yang dibutuhkan untuk membuat omellete
	 */
	public int getNResep(){
		return this.nResep;
	}

    /**
     * getter dari resep
     * @param i index dari bahan di daftar bahan
     * @return nama bahan dari daftar resep di index ke i
     */
	public String getResep(int i){
		assert(i >= 0 && i < nResep);
		return (resep[i]);
	}

	/**
     * Konstruktor dari class Omellete
     */
	public Omellete(){
		super("Omellete", 15000);
	}
}