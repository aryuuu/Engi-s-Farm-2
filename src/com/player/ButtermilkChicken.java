package com.player;
/**
 * file Meatball.java
 * <p>
 *     Kelas yang merepresentasikan produk yang didapat setelah player mengolah CowMilk dan ChickenMeat
 * </p>
 *
 * @author M Algah Fattah Illahi
 *
 * @version 1.0
 *`
 * @since 2019-04-13
 */
public class ButtermilkChicken extends Product implements SideProduct{
	// Atribut
    /**
     *  Atribut yang merupakan jumlah dari bahan yang dibutuhkan untuk membuat buttermilk chicken
     */
	private int nResep = 2;
	/**
     *  Atribut yang merupakan daftar nama dari produk yang dibutuhkan untuk membuat buttermilk chicken
     */
	private String resep[] = {"ChickenMeat", "CowMilk"};
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
     * Konstruktor dari class ButtermilkChicken
     */
	public ButtermilkChicken(){
		super("ButtermilkChicken", 45000);
	}
}