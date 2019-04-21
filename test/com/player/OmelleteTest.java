package com.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OmelleteTest {
    Omellete dadar = new Omellete();
    @Test
    void getNResep() {
        assertEquals(2, dadar.getNResep());
    }

    @Test
    void getResep() {
        assertEquals("CowMilk", dadar.getResep(0));
    }
}