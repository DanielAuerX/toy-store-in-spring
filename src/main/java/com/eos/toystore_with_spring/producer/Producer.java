package com.eos.toystore_with_spring.producer;

public class Producer {


    private final Integer producerId;
    //@NotBlank
    private final String name;
    private final String email;


    public Producer(Integer producerId, String name, String email) { //@JsonProperty("firstName") String firstName
        this.producerId = producerId;
        this.name = name;
        this.email = email;
    }
}
