package com.eos.toystore_with_spring.toys;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public abstract class AbstractToy {
    @Id
    private UUID uuid;
    private String name;
    private ToySize size;
    private int producerId;

    public AbstractToy(UUID uuid, String name, ToySize size, int producerId) {
        this.name = name;
        this.size = size;
        this.uuid = uuid;
        this.producerId = producerId;
    }

    public AbstractToy() {

    }

    public abstract String play();

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public ToySize getSize() {
        return size;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(ToySize size) {
        this.size = size;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "uuid=" + uuid.toString() +
                ", name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
