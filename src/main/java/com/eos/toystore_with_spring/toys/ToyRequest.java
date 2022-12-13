package com.eos.toystore_with_spring.toys;

import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public record ToyRequest(@NotBlank String classType,
                         @NotBlank String name,
                         @NotBlank String size,
                         @NonNull int producerId,
                         int numberOfWheels) {
}
