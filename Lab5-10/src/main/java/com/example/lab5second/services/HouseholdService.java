package com.example.lab5second.services;

import com.example.lab5second.entities.Household;

import java.util.List;

public interface HouseholdService {
    Household findByEircode(String eircode);
    Household findByEircodeWithPets(String eircode);
    List<Household> findHouseholdsWithNoPets();
    List<Household> getAllHouseholds();
    Household saveHousehold(Household household);
    void deleteHousehold(String eircode);
}
