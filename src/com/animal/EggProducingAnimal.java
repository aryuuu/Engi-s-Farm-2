package com.animal;

/**
 * file EggProducingAnimal.java
 * <p>
 *     Interface yang menggambarkan animal-animal yang menghasilkan telur jika diinteract
 * </p>
 *
 * @author Jan Meyer Saragih / 13517131
 *
 * @version 1.0
 *`
 * @since 2019-04-14
 */

 interface EggProducingAnimal
 {
     // Method

     /**
     * Mengembalikan produk hasil interaksi (telur) dari binatang tersebut
     *
     * @return telur dari bintang tersebut
     */
     public String interactProduct();
 }