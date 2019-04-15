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
     * Mengembalikan produk hasil kill (daging) dari binatang tersebut
     *
     * @return daging dari bintang tersebut
     */
     public String killProduct();
 }