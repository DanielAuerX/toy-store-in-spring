package com.eos.toystore_with_spring.toys;

import com.eos.toystore_with_spring.toys.Starship;
import com.eos.toystore_with_spring.toys.ToySize;
import org.junit.jupiter.api.Assertions;


import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class StarshipTest {

    @org.junit.jupiter.api.Test
    void shipShouldTravelForward() {
        Starship starship = new Starship(UUID.randomUUID(), "Enterprise", ToySize.XL, 1);
        starship.setSpeed(9);
        String result = starship.play();

        assertEquals("Enterprise traveled 9 light years through the galaxy!", result);
    }

    @org.junit.jupiter.api.Test
    void shipShouldTravelBackward() {
        Starship starship = new Starship(UUID.randomUUID(), "Enterprise", ToySize.XL, 1);
        starship.setSpeed(-9);
        String result = starship.play();

        assertEquals("Enterprise traveled 9 light years through the galaxy!", result);
    }

    @org.junit.jupiter.api.Test
    void shipShouldDoARoundtrip() {
        Starship starship = new Starship(UUID.randomUUID(), "Enterprise", ToySize.XL, 1);
        starship.setSpeed(9);
        String result = starship.play();
        starship.setSpeed(-9);
        result = starship.play();

        assertEquals("Enterprise traveled 18 light years through the galaxy!", result);
    }

    @org.junit.jupiter.api.Test
    void shipSpeedShouldbeZeroAfterLanding() {
        Starship starship = new Starship(UUID.randomUUID(), "Enterprise", ToySize.XL, 1);
        starship.land();

        Assertions.assertEquals(0, starship.getSpeed());
    }

}