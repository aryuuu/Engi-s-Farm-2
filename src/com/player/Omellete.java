package com.player;
/**
 * @author M Algah Fattah Illahi/13517122
 *@Kelas Omellete
 *
 *@Kelas ini merupakan kelas dari objek 
 * yang didapat setelah player mengolah ChickenEgg, CowMilk
*/
public class Omellete extends Product implements SideProduct{
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
	private String resep[2] = {"CowMilk", "ChickenEgg"};
	/**
	 *@method ini tidak menerima argumen apapun
	 *@method ini mengembalikan jumlah bahan 
	 * yang dibutukan untuk membuat produk ini
	*/
	public int getNResep(){
		return this.nResep;
	}
	/**
	 *@method ini menerima satu argumen integer i, integer yang merupakan index bahan
	 * yang terdapat pada array nama bahan
	 *@method ini mengembalikan nama bahan yang terdapat di index ke-i
	*/
	public String getResep(int i){
		return this.resep[i];
	}

	public Omellete(){
		super("Omellete", 15000);
	}
}