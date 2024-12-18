package com.example.lab5second.services;

import com.example.lab5second.entities.Pet;
import com.example.lab5second.exceptions.PetNotFoundException;

import java.util.List;

public interface PetService {
    Pet createPet(Pet pet);
    Pet getPetById(Long id) throws PetNotFoundException;
    void deletePetById(Long id) throws PetNotFoundException;
    List<Pet> findPetsByBreedOrderByAge(String breed);
    double getAverageAge();
    Pet getOldestPet() throws PetNotFoundException;
    List<Pet> getAllPets();
    Pet getPet(Long id);
    Pet savePet(Pet pet);
    void deletePet(Long id);
    Pet updatePetName(Long id, String name);
    
}
