package com.player;
/**
 * @author M Algah Fattah Illahi/13517122
 *@Kelas ButtermilkChicken
 *
 *@Kelas ini merupakan kelas dari objek 
 * yang didapat setelah player mengolah ChickenMeat, CowMilk
*/
public class ButtermilkChicken extends Product implements SideProduct{
/**
	 *@nResep merupakan atribut yang menyimpan jumlah 
	 * bahan yang dibutuhkan untuk membuat produk ini
	*/
	private int nResep = 2;
	/*
	 *@resep merupakan atribut yang berisi daftar
	 * nama bahan yang dibutuhkan untuk membuat 
	 * produk ini
	*/
	private String resep[2] = {"ChickenMeat", "CowMilk"};
	/**
	 *@method ini tidak menerima argumen apapun
	 *@method ini mengembalikan jumlah bahan 
	 * yang dibutukan untuk membuat produk ini
	*/
	public int getNResep();
	/**
	 *@method ini menerima satu argumen integer i, integer yang merupakan index bahan
	 * yang terdapat pada array nama bahan
	 *@method ini mengembalikan nama bahan yang terdapat di index ke-i
	*/
	public String getResep(int i);

	public ButtermilkChicken(){
		super("ButtermilkChicken", 45000);
	}
}