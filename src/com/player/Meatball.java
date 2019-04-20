package com.player;
/**
 * file Meatball.java
 * <p>
 *     Kelas yang merepresentasikan produk yang didapat setelah player mengolah CowMeat, CowMilk dan ChickenEgg
 * </p>
 *
 * @author M Algah Fattah Illahi
 *
 * @version 1.0
 *`
 * @since 2019-04-13
 */
public class Meatball extends Product implements SideProduct{
	// Atribut
    /**
     *  Atribut yang merupakan jumlah dari bahan yang dibutuhkan untuk membuat meatball
     */
	private int nResep = 3;
	
	/**
     *  Atribut yang merupakan daftar nama dari produk yang dibutuhkan untuk membuat meatball
     */
	private String resep[] = {"CowMeat", "CowMilk", "ChickenEgg"};
	
	// Getter
	/**
	 * getter dari nResep
	 * @return nresep yang merupakan jumlah bahan yang dibutuhkan untuk membuat meatball
	 */

	public int getNResep()
	{
		return nResep;
	}
	/**
     * getter dari resep
     * @param i index dari bahan di daftar resep
     * @return nama bahan dari daftar resep di index ke i
     */
	public String getResep(int i)
	{
		assert(i >= 0 && i < nResep);
		return (resep[i]);
	}

	/**
     * Konstruktor dari class Meatball
     */
	public Meatball(){
		super("Meatball", 150000);
	}
}