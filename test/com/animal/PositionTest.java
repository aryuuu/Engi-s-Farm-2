package com.animal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    Position pos = new Position(1, 1);

    @Test
    void getRow() {
        assertEquals(1, pos.getRow());
    }

    @Test
    void getColumn() {
        assertEquals(1, pos.getColumn());
    }

    @Test
    void equals1() {
        Position pos2 = new Position(1, 1);
        Position pos3 = new Position(1, 2);
        assertTrue(pos.equals(pos2));
        assertFalse(pos.equals(pos3));
    }
}