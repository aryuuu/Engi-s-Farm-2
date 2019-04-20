package com.player;
/**
 * file ChickenEgg.java
 * <p>
 *     Kelas yang merepresentasikan produk yang didapat setelah player menyembelih Rabbit
 * </p>
 *
 * @author M Algah Fattah Illahi / 13517122
 *
 * @version 1.0
 *`
 * @since 2019-04-13
 */
interface SideProduct{
	
	/**
	 * getter
	 * @return [description]
	 */
	int getNResep();
	/**
	 * getter dari resep
	 * @param  i index dari bahan di daftar resep
	 * @return  nama bahan yang berada di daftar resep di index ke i
	 */
	String getResep(int i);
}