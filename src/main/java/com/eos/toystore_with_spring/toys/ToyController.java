package com.eos.toystore_with_spring.toys;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/toys")
public class ToyController {
    private final ToyRepository toyRepository;

    public ToyController(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    @GetMapping
    public List<AbstractToy> getToys(){
        return toyRepository.findAll();
    }

    @GetMapping("{toyId}")
    public ResponseEntity<String> getToyById(@PathVariable("toyId") String id) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (MethodArgumentTypeMismatchException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid toy id!");
        }
        Optional<AbstractToy> toyOptional = toyRepository.findById(uuid);
        return toyOptional.map(abstractToy -> ResponseEntity.ok(abstractToy.toString()))
                .orElseGet(() -> ResponseEntity.badRequest().body("No toy with this id!"));
    }



    @PostMapping
    public ResponseEntity<String> addToy(@RequestBody ToyRequest request) {
        try {
            AbstractToy toy = ToyFactory.create(request.classType(), UUID.fromString(request.uuid()), request.name(),
                    ToySize.valueOf(request.size()), request.producerId(), request.numberOfWheels());
        toyRepository.save(toy);
        return ResponseEntity.ok("The toy has been added!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Something went wrong :(\nCheck if you entered the correct parameters.");
        }
    }

    @DeleteMapping("delete/{toyId}")
    public void deleteToy(@PathVariable("toyId") UUID uuid){
        toyRepository.deleteById(uuid);
    }


    @PutMapping("update/{toyId}")
    public ResponseEntity<Boolean> updateToy(@PathVariable("toyId") UUID uuid,
                             @RequestBody ToyRequest request){
        Optional<AbstractToy> customerOptional = toyRepository.findById(uuid);
        if (customerOptional.isPresent()){
            AbstractToy toy = customerOptional.get();
            toy.setName(request.name());
            toy.setSize(ToySize.valueOf(request.size()));
            toy.setProducerId(request.producerId());
            toyRepository.save(toy);
            return ResponseEntity.ok(true);
        }
        else {
            return ResponseEntity.badRequest().body(false);
        }
    }

    //update only the name:
    @PutMapping("/update/name/{toyId}")
    public ResponseEntity<Boolean> updateToyName(@PathVariable("toyId") UUID uuid, @RequestParam(value = "name") String name){
        Optional<AbstractToy> toyOptional = toyRepository.findById(uuid);
        if (toyOptional.isPresent()){
            AbstractToy toy = toyOptional.get();
            toy.setName(name);
            toyRepository.save(toy);
            return ResponseEntity.ok(true);
        }
        else {
            return ResponseEntity.badRequest().body(false);
        }
    }


}
