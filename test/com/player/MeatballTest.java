package com.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeatballTest {
    Meatball bakso = new Meatball();
    @Test
    void getNResep() {
        assertEquals(3, bakso.getNResep());
    }

    @Test
    void getResep() {
        assertEquals("CowMeat", bakso.getResep(0));
    }


}