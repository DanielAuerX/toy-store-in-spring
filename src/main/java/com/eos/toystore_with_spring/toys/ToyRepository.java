package com.eos.toystore_with_spring.toys;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ToyRepository extends JpaRepository<AbstractToy, UUID>{}
