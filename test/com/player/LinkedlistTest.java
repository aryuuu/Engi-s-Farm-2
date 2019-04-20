package com.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedlistTest {
    Linkedlist<Integer> L = new Linkedlist<Integer>();
    @Test
    void size() {
        L.add(3);
        L.add(5);
        assertEquals(2,L.size());
    }

    @Test
    void isEmpty() {
        assertEquals(true,L.isEmpty());
        L.add(5);
        assertEquals(false,L.isEmpty());
    }
    @Test
    void add() {
        L.add(3);
        assertEquals(3,L.get(1));
    }

    @Test
    void remove() {
        L.add(4);
        L.add(2);
        L.remove(1);
        assertEquals(2,L.get(1));
    }

    @Test
    void get() {
        L.add(1);
        assertEquals(1,L.get(1));
    }
}