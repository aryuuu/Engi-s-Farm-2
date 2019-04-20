package com.player;
/**
 * file Product.java
 * <p>
 *     Kelas yang merepresentasikan produk yang didapat setelah player berinteraksi atau membunuh animal
 * </p>
 *
 * @author M Algah Fattah Illahi
 *
 * @version 1.0
 *`
 * @since 2019-04-13
 */
public class Product{
	// Atribut
    /**
     *  Atribut yang merupakan nama dari produk
     */
	protected String nama;

	/**
     *  Atribut yang merupakan harga dari produk
     */
	protected int harga;

	 /**
     * Konstruktor dari class Product
     */
	public Product(String nama, int harga){
		assert(harga > 0);
		this.nama = nama;
		this.harga = harga;
	}

	// Getter

    /**
     * getter dari nama
     * @return nama yang merupakan nama dari player
     */
	public String getNama(){
		return this.nama;
	}
	/**
     * getter dari produk
     * @return harga yang merupakan harga dari produk
     */
	public int getHarga(){
		return this.harga;
	}

	//setter

    /**
     * setter dari nama
     * @param nama
     */
	public void setNama(String nama) {
		this.nama = nama;
	}

	/**
     * setter dari harga
     * @param harga
     */
	public void setHarga(int harga) {
		this.harga = harga;
	}

	/**
     * method untuk membandingkan nama produk 
     * @param p
     */
	public boolean samaDengan(Product p){
		return this.nama == p.getNama();
	}
}