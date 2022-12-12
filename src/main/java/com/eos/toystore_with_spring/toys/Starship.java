package com.eos.toystore_with_spring.toys;

import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class Starship extends AbstractToy {
    private int speed;
    private int distanceTraveled;

    public Starship(UUID uuid, String name, ToySize size, int producerId) {
        super(uuid, name, size, producerId);
        speed = 0;
        distanceTraveled = 0;
    }

    public Starship() {

    }

    @Override
    public String play() {
        this.distanceTraveled += Math.abs(speed);
        return this.getName() + " traveled " + distanceTraveled + " light years through the galaxy!";
    }

    public void land() {
        this.setSpeed(0);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }
}
