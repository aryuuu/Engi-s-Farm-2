package com.animal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChickenTest {

    Chicken ani = new Chicken(1, 1);

    @Test
    void animalType() {
        assertEquals("Chicken", ani.animalType());
    }

    @Test
    void animalHabitat() {
        assertEquals("Coop", ani.animalHabitat());
    }

    @Test
    void animalSound() {
    }

    @Test
    void printTile() {
    }

    @Test
    void canProduceEgg() {
    }

    @Test
    void eggProduct() {
    }

    @Test
    void canProduceMeat() {
    }

    @Test
    void meatProduct() {
    }

    @Test
    void canProduceMilk() {
    }

    @Test
    void milkProduct() {
    }
}