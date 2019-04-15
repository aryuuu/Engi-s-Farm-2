package com.player;
/**
 *@Kelas Product
 *
 *@harga merupakan harga dari produk
 *@nama merupakan nama produk
 *@
*/
public class Product{
	protected String nama;
	protected int harga;


		/*
		 *@constructor product menerima dua argumen
		 * argumen pertama adalah String yang merupakan nama produk
		 * argumen kedua merupakan integer yang merupakan harga produk
		*/
	public Product(String nama, int harga){
		assert(harga > 0);
		this.nama = nama;
		this.harga = harga;
	}

		/*
		 *@method ini tidak menerima argumen apapun
		 *@method yang mengembalikan nama produk
		*/
	public String getNama(){
		return this.nama;
	}
		/*
		 *@method ini tidak menerima argumen apapun
		 *@method yang mengembalikan harga produk
		*/
	public int getHarga(){
		return this.harga;
	}

		/*
		 *@method ini menerima satu argumen berupa Product
		 *@method ini mengembalikan true jika objek memiliki
		 * nama yang sama dengan p
		*/
	public boolean samaDengan(Product p){
		return this.nama == p.getNama();
	}



}