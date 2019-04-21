package com.animal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RabbitTest {

    Rabbit ani = new Rabbit(1, 1);

    @Test
    void getLocation() {
        assertEquals(1, ani.getLocation().getRow());
        assertEquals(1, ani.getLocation().getColumn());
    }

    @Test
    void getX() {
        assertEquals(1, ani.getLocation().getRow());
    }

    @Test
    void getY() {
        assertEquals(1, ani.getLocation().getColumn());
    }

    @Test
    void getHungerCounter() {
        assertEquals(0, ani.getHungerCounter());
    }

    @Test
    void getHungry() {
        assertTrue(ani.getHungry());
    }

    @Test
    void isDead() {
        assertFalse(ani.isDead());
    }

    @Test
    void isPosition() {
        assertTrue(ani.isPosition(1, 1));
        assertFalse(ani.isPosition(1, 2));
    }

    @Test
    void isNear() {
        assertTrue(ani.isNear(1, 2));
        assertFalse(ani.isNear(1, 1));
    }

    @Test
    void animalType() {
        assertEquals("Rabbit", ani.animalType());
    }

    @Test
    void animalHabitat() {
        assertEquals("Grassland", ani.animalHabitat());
    }

    @Test
    void animalSound() {
        assertEquals("Krrr--Krrrr", ani.animalSound());
    }

    @Test
    void canProduceEgg() {
        assertFalse(ani.canProduceEgg());
    }

    @Test
    void eggProduct() {
        assertEquals("none", ani.eggProduct());
    }

    @Test
    void canProduceMeat() {
        assertTrue(ani.canProduceMeat());
    }

    @Test
    void meatProduct() {
        assertEquals("RabbitMeat", ani.meatProduct());
    }

    @Test
    void canProduceMilk() {
        assertFalse(ani.canProduceMilk());
    }

    @Test
    void milkProduct() {
        assertEquals("none", ani.milkProduct());
    }
}