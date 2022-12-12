package com.eos.toystore_with_spring;

import com.eos.toystore_with_spring.toys.AbstractToy;
import com.eos.toystore_with_spring.toys.Car;
import com.eos.toystore_with_spring.toys.Starship;
import com.eos.toystore_with_spring.toys.ToySize;
import com.eos.toystore_with_spring.warehouse.Shelf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ShelfTest {

    @Test
    void add1() {
        Shelf shelf = new Shelf(15);
        AbstractToy toy1 = new Car(UUID.randomUUID(), "Lightnig McQueen", ToySize.S, 1, 4);
        AbstractToy toy2 = new Starship(UUID.randomUUID(),"Milenium Falke", ToySize.L, 1);

        Assertions.assertTrue(shelf.add(toy1));
        Assertions.assertTrue(shelf.add(toy2));
    }

    @Test
    void add2() {
        Shelf shelf = new Shelf(15);
        AbstractToy toy1 = new Starship(UUID.randomUUID(),"Enterprise", ToySize.XL,1 );

        Assertions.assertFalse(shelf.add(toy1));
    }

    @Test
    void add3() {
        Shelf shelf = new Shelf(15);
        AbstractToy toy1 = new Car(UUID.randomUUID(), "Lightnig McQueen", ToySize.S, 1, 4);

        Assertions.assertTrue(shelf.add(toy1));
        Assertions.assertTrue(shelf.add(toy1));
        Assertions.assertTrue(shelf.add(toy1));
        Assertions.assertTrue(shelf.add(toy1));
        Assertions.assertTrue(shelf.add(toy1));
        Assertions.assertTrue(shelf.add(toy1));
        Assertions.assertTrue(shelf.add(toy1));
        Assertions.assertFalse(shelf.add(toy1));
    }

    @Test
    void remove1() {
        Shelf shelf = new Shelf(15);
        AbstractToy toy1 = new Car(UUID.randomUUID(), "Lightnig McQueen", ToySize.S, 1, 4);
        shelf.add(toy1);

        Assertions.assertEquals(toy1, shelf.remove(toy1.getName()));
    }

    @Test
    void remove2() {
        Shelf shelf = new Shelf(15);
        AbstractToy toy1 = new Car(UUID.randomUUID(), "Lightnig McQueen", ToySize.S, 1, 4);
        shelf.add(toy1);
        AbstractToy toy2 = new Car(UUID.randomUUID(), "Lightnig McQueen", ToySize.S, 1, 4);
        shelf.add(toy2);

        Assertions.assertEquals(toy2.getName(), shelf.remove(toy1.getName()).getName());
    }

    @Test
    void testToString() {
        Shelf shelf = new Shelf(15);
        AbstractToy toy1 = new Car(UUID.randomUUID(), "Lightnig McQueen", ToySize.S, 1, 4);
        AbstractToy toy2 = new Starship(UUID.randomUUID(),"Milenium Falke", ToySize.L, 1);
        shelf.add(toy1);
        shelf.add(toy2);

        String shelfContent = shelf.toString();
        assertTrue(shelfContent.contains("Lightnig McQueen"));
        assertTrue(shelfContent.contains("Milenium Falke"));
        assertTrue(shelfContent.contains(toy1.getUuid().toString()));
        assertTrue(shelfContent.contains(toy2.getUuid().toString()));
    }
}