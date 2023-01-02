package com.eos.toystore_with_spring.toys;

import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class Car extends AbstractToy implements Drivable, WheeledVehicle{
    private String classType;
    private String url;
    private int speed;
    private int distanceTraveled;
    private int numberOfWheels;

    public Car(UUID uuid, String name, ToySize size, int producerId, int numberOfWheels) {
        super(uuid, name, size, producerId);
        classType = "Car";
        url = "https://www.kidsroom.de/WebRoot/KidsroomDE/Shops/Kidsroom/4CBE/0CAE/F074/6FA6/7A5F/4DEB/AE1B/D04D/BILD3_7022066.jpg";
        speed = 0;
        distanceTraveled = 0;
        this.numberOfWheels = numberOfWheels;
    }

    public Car() {

    }

    @Override
    public String play() {
        this.distanceTraveled += Math.abs(speed);
        return this.getName() + " traveled " + distanceTraveled + " miles on route 66!";
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

    public String getClassType() {
        return classType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public int drive() {
        this.distanceTraveled += speed;
        return distanceTraveled;
    }
}
