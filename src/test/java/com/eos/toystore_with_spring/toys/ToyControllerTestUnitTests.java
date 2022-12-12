package com.eos.toystore_with_spring.toys;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ToyControllerTestUnitTests {


    @Mock
    ToyRepository mockedToyRepository;

    @Test
    void getToys() {
        // 100% JpaRepository
    }

    @Test
    void getToyById() {
        UUID uuid = UUID.randomUUID();
        Car car = new Car(uuid, "Ford GT40", ToySize.L, 1, 4);
        when(mockedToyRepository.findById(uuid)).thenReturn(Optional.of(car));
        ToyController toyController = new ToyController(mockedToyRepository);

        ResponseEntity<String> actual = toyController.getToyById(uuid.toString());

        assertEquals(car.toString(), actual.getBody());
        assertEquals(HttpStatusCode.valueOf(200), actual.getStatusCode());
    }

    @Test
    void getToyById_wrongUuid() {
        ToyController toyController = new ToyController(mockedToyRepository);
        ResponseEntity<String> expected = ResponseEntity.badRequest().body("Invalid toy id!");

        ResponseEntity<String> actual = toyController.getToyById("1234-1234-123asdfafa");

        assertEquals(expected, actual);
    }

    @Test
    void getToyById_noToyFound() {
        ToyController toyController = new ToyController(mockedToyRepository);
        ResponseEntity<String> expected = ResponseEntity.badRequest().body("No toy with this id!");

        ResponseEntity<String> actual = toyController.getToyById(UUID.randomUUID().toString());

        assertEquals(expected, actual);
    }

    @Test
    void addToy_withCorrectData() {
        String uuid = UUID.randomUUID().toString();
        ToyController toyController = new ToyController(mockedToyRepository);
        ToyRequest request = new ToyRequest("Car", uuid,
                "Speedo", "S", 1, 4);

        ResponseEntity<String> actual = toyController.addToy(request);

        assertEquals(ResponseEntity.ok("The toy has been added!"), actual);
    }

    @Test
    void addToy_withNonExistingToyType() {
        String uuid = UUID.randomUUID().toString();
        ToyController toyController = new ToyController(mockedToyRepository);
        String nonExistingToyType = "Tasse";
        ToyRequest request = new ToyRequest(nonExistingToyType, uuid,
                "Speedo", "S", 1, 4);
        ResponseEntity<String> expected = ResponseEntity.badRequest().body("Something went wrong :(\nCheck if you entered the correct parameters.");

        ResponseEntity<String> actual = toyController.addToy(request);

        assertEquals(expected, actual);
    }

    @Test
    void deleteCustomer() {
        // 100% JpaRepository
    }

    @Test
    void updateCustomer_IncorrectIdShouldReturnFalse() {
        UUID uuid = UUID.randomUUID();
        ToyController toyController = new ToyController(mockedToyRepository);
        ToyRequest request = new ToyRequest("Car", uuid.toString(),
                "Ford Focus", "XL", 1, 4);

        ResponseEntity<Boolean> actual = toyController.updateToy(UUID.randomUUID(), request);

        assertEquals(Boolean.FALSE, actual.getBody());
        assertEquals(HttpStatusCode.valueOf(400), actual.getStatusCode());
    }

    @Test
    void updateCustomer_CorrectIdShouldReturnTrue() {
        UUID uuid = UUID.randomUUID();
        ToyRequest request = new ToyRequest("Car", uuid.toString(),
                "Ford Focus", "XL", 1, 4);
        Car car = new Car(uuid, "Ford GT40", ToySize.L, 1, 4);
        when(mockedToyRepository.findById(uuid)).thenReturn(Optional.of(car));
        ToyController toyController = new ToyController(mockedToyRepository);

        ResponseEntity<Boolean> actual = toyController
                .updateToy(uuid, request);

        assertEquals(Boolean.TRUE, actual.getBody());
        assertEquals(HttpStatusCode.valueOf(200), actual.getStatusCode());
    }

    @Test
    void updateCustomerName_CorrectIdShouldReturnTrue() {
        UUID uuid = UUID.randomUUID();
        Car car = new Car(uuid, "Ford GT40", ToySize.L, 1, 4);
        when(mockedToyRepository.findById(uuid)).thenReturn(Optional.of(car));
        ToyController toyController = new ToyController(mockedToyRepository);

        ResponseEntity<Boolean> actual = toyController.updateToyName(uuid, "Ford Focus");

        assertEquals(Boolean.TRUE, actual.getBody());
        assertEquals(HttpStatusCode.valueOf(200), actual.getStatusCode());
    }

    @Test
    void updateCustomerName_IncorrectIdShouldReturnFalse() {
        ToyController toyController = new ToyController(mockedToyRepository);

        ResponseEntity<Boolean> actual = toyController
                .updateToyName(UUID.randomUUID(), "Ford Focus");

        assertEquals(Boolean.FALSE, actual.getBody());
        assertEquals(HttpStatusCode.valueOf(400), actual.getStatusCode());
    }
}