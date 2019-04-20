package com.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player P = new Player();
    @Test
    void getWater() {
        assertEquals(0,P.getWater());
    }

    @Test
    void getMoney() {
        assertEquals(0,P.getMoney());
    }

    @Test
    void getX() {
        assertEquals(0,P.getX());
    }

    @Test
    void getY() {
        assertEquals(0,P.getY());
    }

    @Test
    void getBag() {
        P.addProduct("CowMilk");
        CowMilk O = new CowMilk();
        assertEquals(O.getNama(),P.getBag(1).getNama());
    }

    @Test
    void getSizeBag() {
        assertEquals(0,P.getSizeBag());
    }
    @Test
    void setWater() {
        P.setWater(20);
        assertEquals(20,P.getWater());
    }

    @Test
    void setMoney() {
        P.setMoney(2000);
        assertEquals(2000,P.getMoney());
    }

    @Test
    void setX() {
        P.setX(3);
        assertEquals(3,P.getX());
    }

    @Test
    void setY() {
        P.setY(3);
        assertEquals(3,P.getY());
    }
    @Test
    void playerMove() {
        P.playerMove('r');
        P.playerMove('s');
        assertEquals(1,P.getX());
        assertEquals(1,P.getY());
    }
    @Test
    void delProductAll() {
        P.addProduct("CowMilk");
        P.addProduct("CowMilk");
        P.addProduct("CowMilk");
        P.delProductAll();
        assertEquals(0,P.getSizeBag());
    }
    @Test
    void reduceWater() {
        P.addWater();
        P.reduceWater();
        assertEquals(24, P.getWater());
    }

    @Test
    void addProduct() {
        P.addProduct("CowMilk");
        assertEquals(new CowMilk().getNama(),P.getBag(1).getNama());
    }

    @Test
    void addProduct1() {
        P.addProduct(new CowMeat());
        assertEquals(new CowMeat().getNama(),P.getBag(1).getNama());
    }

    @Test
    void addWater() {
        P.addWater();
        assertEquals(25, P.getWater());
    }

    @Test
    void addMoney() {
        P.addMoney(2000);
        assertEquals(2000, P.getMoney());
    }

    @Test
    void isValid() {
        assertEquals(true,P.isValid(0,0));
    }

    @Test
    void isAvailable() {
        P.addProduct("ChickenEgg");
        P.addProduct("CowMilk");
        assertEquals(true, P.isAvailable("Omellete"));
    }
}