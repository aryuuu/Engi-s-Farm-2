package com.animal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalContainerTest {

    AnimalContainer ac = new AnimalContainer();
    Chicken ani1 = new Chicken(1, 1);
    Cow ani2 = new Cow(2, 2);

    @Test
    void getAnimal() {
        ac.addAnimal(ani1);
        ac.addAnimal(ani2);
        assertEquals(1, ac.getAnimal(0).getLocation().getRow());
    }

    @Test
    void getNumAnimal() {
        ac.addAnimal(ani1);
        ac.addAnimal(ani2);
        assertEquals(2, ac.getNumAnimal());
    }

    @Test
    void animalOn() {
        ac.addAnimal(ani1);
        ac.addAnimal(ani2);
        assertEquals(0, ac.animalOn(1, 1));
        assertEquals(-1, ac.animalOn(3, 3));
    }

    @Test
    void animalNear() {
        ac.addAnimal(ani1);
        ac.addAnimal(ani2);
        assertEquals(-1, ac.animalNear(1, 1));
        assertEquals(1, ac.animalNear(3, 2));
    }
}