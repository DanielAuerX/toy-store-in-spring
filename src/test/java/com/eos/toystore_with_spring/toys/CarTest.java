package com.eos.toystore_with_spring.toys;

import com.eos.toystore_with_spring.toys.Car;
import com.eos.toystore_with_spring.toys.ToySize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void carShouldTravelForward() {
        Car car = new Car(UUID.randomUUID(), "Eleanore", ToySize.S, 1, 4);
        car.setSpeed(9);
        String result = car.play();

        assertEquals("Eleanore traveled 9 miles on route 66!", result);
    }

    @Test
    void shipShouldTravelBackward() {
        Car car = new Car(UUID.randomUUID(), "Eleanore", ToySize.S, 1, 4);
        car.setSpeed(-9);
        String result = car.play();

        assertEquals("Eleanore traveled 9 miles on route 66!", result);
    }

    @Test
    void shipShouldDoARoundtrip() {
        Car car = new Car(UUID.randomUUID(), "Eleanore", ToySize.S, 1, 4);
        car.setSpeed(9);
        String result = car.play();
        car.setSpeed(-9);
        result = car.play();

        assertEquals("Eleanore traveled 18 miles on route 66!", result);
    }

    @Test
    void drive() {
        Car car = new Car(UUID.randomUUID(), "Eleanore", ToySize.S, 1, 4);
        car.setSpeed(5);
        Assertions.assertEquals(5, car.drive());
    }
}
