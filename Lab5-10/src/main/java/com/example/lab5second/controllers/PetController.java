package com.example.lab5second.controllers;

import com.example.lab5second.entities.Pet;
import com.example.lab5second.services.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    // 1. Get all pets
    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = petService.getAllPets();
        return ResponseEntity.ok(pets);
    }

    // 2. Get a pet by ID
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        Pet pet = petService.getPet(id);
        if (pet != null) {
            return ResponseEntity.ok(pet);
        }
        return ResponseEntity.notFound().build();
    }

    // 3. Delete a pet
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }

    // 4. Create a new pet
    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        Pet savedPet = petService.savePet(pet);
        return ResponseEntity.status(201).body(savedPet);
    }

    // 5. Update a pet's name
    @PatchMapping("/{id}/name")
    public ResponseEntity<Pet> updatePetName(@PathVariable Long id, @RequestParam String name) {
        Pet updatedPet = petService.updatePetName(id, name);
        if (updatedPet != null) {
            return ResponseEntity.ok(updatedPet);
        }
        return ResponseEntity.notFound().build();
    }
}
