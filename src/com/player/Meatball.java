package com.player;
/**
 * @author M Algah Fattah Illahi/13517122
 *@Kelas Meatball
 *
 *@Kelas ini merupakan kelas dari objek 
 * yang didapat setelah player mengolah CowMeat, CowMilk, ChickenEgg
*/
public class Meatball extends Product implements SideProduct{
/**
	 *@nResep merupakan atribut yang menyimpan jumlah 
	 * bahan yang dibutuhkan untuk membuat produk ini
	*/
	private int nResep = 3;
	/*
	 *@resep merupakan atribut yang berisi daftar
	 * nama bahan yang dibutuhkan untuk membuat 
	 * produk ini
	*/
	private String resep[3] = {"CowMeat", "CowMilk", "ChickenEgg"};
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

	public Meatball(){
		super("Meatball", 150000);
	}
}