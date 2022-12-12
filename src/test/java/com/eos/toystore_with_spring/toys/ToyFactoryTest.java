package com.eos.toystore_with_spring.toys;


import org.junit.jupiter.api.Test;
import com.eos.toystore_with_spring.toys.AbstractToy;
import com.eos.toystore_with_spring.toys.Car;
import com.eos.toystore_with_spring.toys.Starship;
import com.eos.toystore_with_spring.toys.ToySize;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ToyFactoryTest {
/*
    @Test
    void create_Starship() {
        String classType = "Starship";
        UUID uuid = UUID.randomUUID();
        String name = "Titanic";
        ToySize size = ToySize.M;
        int producerId = 2;

        ToyFactory factory = new ToyFactory(classType, uuid, name, size, producerId);
        AbstractToy toy = factory.create();

        assertTrue(toy instanceof Starship);
        assertEquals(toy.getName(), name);
        assertEquals(toy.getSize(), size);
    }

    @Test
    void create_Car() {
        String classType = "Car";
        UUID uuid = UUID.randomUUID();
        String name = "Brum";
        ToySize size = ToySize.M;
        int producerId = 2;
        int numberOfWheels = 4;

        ToyFactory factory = new ToyFactory(classType, uuid, name, size, producerId, numberOfWheels);
        AbstractToy toy = factory.create();

        assertTrue(toy instanceof Car);
        assertEquals(toy.getName(), name);
        assertEquals(toy.getSize(), size);
        assertEquals(((Car) toy).getNumberOfWheels(), numberOfWheels);
    }
     */
   }
