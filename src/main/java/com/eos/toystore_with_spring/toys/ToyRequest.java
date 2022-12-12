package com.eos.toystore_with_spring.toys;

public record ToyRequest(String classType,
                         String uuid,
                         String name,
                         String size,
                         int producerId,
                         int numberOfWheels) {
}
