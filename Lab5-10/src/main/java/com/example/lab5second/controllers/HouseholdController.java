package com.example.lab5second.controllers;

import com.example.lab5second.entities.Household;
import com.example.lab5second.services.HouseholdService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/households") // Base URL for all endpoints
public class HouseholdController {

    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    // 1. Find Household by Eircode (Without Pets)
    @GetMapping("/{eircode}")
    public Household getHouseholdByEircode(@PathVariable String eircode) {
        return householdService.findByEircode(eircode);
    }

    // 2. Find Household by Eircode with Pets
    @GetMapping("/{eircode}/with-pets")
    public Household getHouseholdByEircodeWithPets(@PathVariable String eircode) {
        return householdService.findByEircodeWithPets(eircode);
    }

    // 3. Find List of Households with No Pets
    @GetMapping("/no-pets")
    public List<Household> getHouseholdsWithNoPets() {
        return householdService.findHouseholdsWithNoPets();
    }

    // 1. Get all households
    @GetMapping
    public ResponseEntity<List<Household>> getAllHouseholds() {
        List<Household> households = householdService.getAllHouseholds();
        return ResponseEntity.ok(households);
    }

  

   

    // 4. Delete a household
    @DeleteMapping("/{eircode}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHousehold(eircode);
        return ResponseEntity.noContent().build();
    }

    // 5. Create a new household
    @PostMapping
    public ResponseEntity<Household> createHousehold(@RequestBody Household household) {
        Household savedHousehold = householdService.saveHousehold(household);
        return ResponseEntity.status(201).body(savedHousehold);
    }
}