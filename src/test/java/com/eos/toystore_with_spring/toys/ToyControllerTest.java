package com.eos.toystore_with_spring.toys;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToyControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private ToyController toyController;


    /*@Test
    void getToys() {
        List entity = template.getForObject("/api/toys", List.class);
        System.out.println(entity);
        //assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
     */

    @Test
    void getToys2() {
        ResponseEntity<List> entity = template.getForEntity("/api/toys", List.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders() //result contains json?
                .getContentType());
    }

    @Test
    void addCustomer() {
    }

    @Test
    void deleteCustomer() {
    }
}