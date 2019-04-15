package com.animal;

/**
 * file MilkProducingAnimal.java
 * <p>
 *     Interface yang menggambarkan animal-animal yang menghasilkan susu jika di-interact
 * </p>
 *
 * @author Jan Meyer Saragih / 13517131
 *
 * @version 1.0
 *`
 * @since 2019-04-14
 */

 interface MilkProducingAnimal
 {
     // Method

     /**
     * Mengembalikan produk hasil interact (susu) dari binatang tersebut
     *
     * @return susu dari bintang tersebut
     */
     public String interactProduct();
 }