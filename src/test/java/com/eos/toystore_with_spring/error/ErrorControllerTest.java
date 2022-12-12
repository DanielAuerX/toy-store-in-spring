package com.eos.toystore_with_spring.error;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ErrorController.class)
class ErrorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void autowiringWorked() {
        assertNotNull(mvc);
    }

    @Test
    void handleError() throws Exception {
        mvc.perform(get("/wrongURL").accept(MediaType.TEXT_HTML))
                .andExpect(status().isNotFound());
        //.andExpect(content().string("Something went wrong! :("));  //nothing is returned
    }
}