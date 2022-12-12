package com.eos.toystore_with_spring.toys;


import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class ToyFactory {

    public static AbstractToy create(String classType, UUID uuid, String name, ToySize size, int producerId, int numberOfWheels) {
        AbstractToy toy;
        try {
            if (numberOfWheels != 0) {
                Class[] classArguments = new Class[]{UUID.class, String.class, ToySize.class, int.class, int.class};
                toy = (AbstractToy) Class.forName("com.eos.toystore_with_spring.toys."+classType).getDeclaredConstructor(classArguments)
                        .newInstance(uuid, name, size, producerId, numberOfWheels);
            } else {
                Class[] classArguments = new Class[]{UUID.class, String.class, ToySize.class, int.class};
                toy = (AbstractToy) Class.forName("com.eos.toystore_with_spring.toys."+classType).getDeclaredConstructor(classArguments)
                        .newInstance(uuid, name, size, producerId);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Something went wrong :(\nCheck if you entered the correct parameters.");
        }
        return toy;
    }
}
