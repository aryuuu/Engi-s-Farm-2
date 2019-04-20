package com.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandTest {
    Land L = new Land(2,5,true,"Grassland");
    @Test

    void getX(){
        assertEquals(2,L.getX());
    }
    void getY(){
        assertEquals(5,L.getY());
    }
    void isGrass() {
        assertEquals(true,L.isGrass());
    }

    @Test
    void setGrass() {
        L.setGrass(false);
        assertEquals(false,L.isGrass());
    }

    @Test
    void getCategory() {
        assertEquals("Grassland",L.getCategory());
    }
}