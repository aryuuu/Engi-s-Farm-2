package com.animal;

/**
 * file MeatProducingAnimal.java
 * <p>
 *     Interface yang menggambarkan animal-animal yang menghasilkan daging jika di-kill
 * </p>
 *
 * @author Jan Meyer Saragih / 13517131
 *
 * @version 1.0
 *`
 * @since 2019-04-14
 */

 interface MeatProducingAnimal
 {
     // Method

    /**
     * Menyatakan apabila animal tersebut menghasilkan daging apabila dibunuh
     *
     * @return animal dapat menghasilkan daging
     */
    public boolean canProduceMeat();

    /**
     * Mengembalikan produk hasil kill (daging) dari binatang tersebut
     *
     * @return daging dari bintang tersebut
     */
    public String meatProduct();
 }