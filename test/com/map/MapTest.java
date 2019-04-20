package com.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    Map M = new Map("Map.txt");
    @Test
    void getMaxRow() {
        assertEquals(24, M.getMaxRow());
    }

    @Test
    void getMaxCol() {
        assertEquals(24, M.getMaxCol());
    }

    @Test
    void getCell() {
        assertEquals("Land",M.getCell(2,2).getLegend());
    }
    @Test
    void isValidPos() {
        assertEquals(true,M.isValidPos(2,2));
    }

    @Test
    void isWithinArea() {
        assertEquals(true,M.isWithinArea(3,3));
    }

    @Test
    void isNear() {
        assertEquals(true, M.isNear(0,22,"Truck"));
    }
}