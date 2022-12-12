package com.eos.toystore_with_spring.toys;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ToyController.class) //only loads the components that are needed for MVC (is faster)
class ToyControllerTestMVC {

    @Autowired
    private MockMvc mvc;

    @Test
    void autowiringWorked() {
        assertNotNull(mvc);
    }

    @Test
    void getToys() {
    }

    @Test
    void getToyById() {
    }

    @Test
    void addCustomer() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void updateCustomerName() {
    }
}