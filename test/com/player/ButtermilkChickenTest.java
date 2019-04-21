package com.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ButtermilkChickenTest {
    ButtermilkChicken kfc = new ButtermilkChicken();
    @Test
    void getNResep() {
        assertEquals(2, kfc.getNResep());
    }

    @Test
    void getResep() {
        assertEquals("ChickenMeat", kfc.getResep(0));
    }
}