package com.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product indomie = new Product("Indomie", 3000);

    @Test
    void getNama() {
        assertEquals("Indomie", indomie.getNama());
    }

    @Test
    void getHarga() {
        assertEquals(3000, indomie.getHarga());
    }

    @Test
    void setNama() {
        indomie.setNama("goreng");
        assertEquals("goreng", indomie.getNama());
    }

    @Test
    void setHarga() {
        indomie.setHarga(4000);
        assertEquals(4000, indomie.getHarga());
    }

    @Test
    void samaDengan() {
        Product sedap = new Product("sedap", 3000);
        assertEquals(false, indomie.samaDengan(sedap));
    }
}