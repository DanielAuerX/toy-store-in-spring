package com.eos.toystore_with_spring;

import com.eos.toystore_with_spring.toys.AbstractToy;
import com.eos.toystore_with_spring.toys.Car;
import com.eos.toystore_with_spring.toys.ToySize;
import com.eos.toystore_with_spring.warehouse.Warehouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    @Test
    void store1() {
        AbstractToy toy2 = new Car(UUID.randomUUID(),"F2", ToySize.M, 1, 4);
        AbstractToy toy1 = new Car(UUID.randomUUID(),"F1", ToySize.M, 1, 4);
        AbstractToy toy3 = new Car(UUID.randomUUID(),"F3", ToySize.M, 1, 4);
        AbstractToy toy4 = new Car(UUID.randomUUID(),"F4", ToySize.M, 1, 4);
        AbstractToy toy5 = new Car(UUID.randomUUID(),"F5", ToySize.M, 1, 4);
        Warehouse wh = new Warehouse(1,1,16);
        Assertions.assertTrue(wh.store(toy1));
        Assertions.assertTrue(wh.store(toy2));
        Assertions.assertTrue(wh.store(toy3));
        Assertions.assertTrue(wh.store(toy4));
        Assertions.assertFalse(wh.store(toy5));
    }

    @Test
    void retrieve_retrieveToy1FromWarehouse() {
        AbstractToy toy1 = new Car(UUID.randomUUID(),"F1", ToySize.M, 1, 4);
        Warehouse wh = new Warehouse(1,1,16);
        wh.store(toy1);

        AbstractToy retrievedToy = wh.retrieve(toy1.getName());
        assertEquals(toy1, retrievedToy);
    }

    @Test
    void retrieve_nonExistingToyNameShouldThrowException() {
        Warehouse wh = new Warehouse(1,1,16);

        assertThrows(RuntimeException.class, () -> {
            wh.retrieve("noRealName");
        });
    }

    @Test
    void getInventoryList() {
        AbstractToy toy2 = new Car(UUID.randomUUID(),"F2", ToySize.M, 1, 4);
        AbstractToy toy1 = new Car(UUID.randomUUID(),"F1", ToySize.M, 1, 4);
        AbstractToy toy3 = new Car(UUID.randomUUID(),"F3", ToySize.M, 1, 4);
        AbstractToy toy4 = new Car(UUID.randomUUID(),"F4", ToySize.M, 1, 4);
        AbstractToy toy5 = new Car(UUID.randomUUID(),"F5", ToySize.M, 1, 4);
        Warehouse wh = new Warehouse(1,1,16);
        Assertions.assertTrue(wh.store(toy1));
        Assertions.assertTrue(wh.store(toy2));
        Assertions.assertTrue(wh.store(toy3));
        Assertions.assertTrue(wh.store(toy4));
        Assertions.assertFalse(wh.store(toy5));

        String warehouseInventoryList = wh.toString();
        assertTrue(warehouseInventoryList.contains("F1"));
        assertTrue(warehouseInventoryList.contains("F2"));
        assertTrue(warehouseInventoryList.contains("F3"));
        assertTrue(warehouseInventoryList.contains("F4"));
        assertFalse(warehouseInventoryList.contains("F5"));
    }
}