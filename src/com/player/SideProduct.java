package com.player;
/**
 *@author M Algah Fattah Illahi/13517122
 *
**/
interface SideProduct{
	/**
	 *@method ini tidak menerima argumen apapun
	 *@method ini mengembalikan jumlah bahan 
	 * yang dibutukan untuk membuat produk ini
	*/
	int getNResep();
	/**
	 *@method ini menerima satu argumen integer i, integer yang merupakan index bahan
	 * yang terdapat pada array nama bahan
	 *@method ini mengembalikan nama bahan yang terdapat di index ke-i
	*/
	String getResep(int i);
}