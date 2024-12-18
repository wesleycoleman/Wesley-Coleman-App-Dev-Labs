package com.example.lab5second.services;

import com.example.lab5second.entities.Pet;
import com.example.lab5second.repositories.PetRepository;
import com.example.lab5second.exceptions.PetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    private PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet createPet(Pet pet) {
        if (pet.getName() == null || pet.getName().isEmpty()) {
            throw new IllegalArgumentException("Pet name cannot be empty");
        }
        return petRepository.save(pet);
    }

    @Override
    public Pet getPetById(Long id) throws PetNotFoundException {
        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException("Pet not found with id: " + id));
    }

    @Override
    public void deletePetById(Long id) throws PetNotFoundException {
        if (!petRepository.existsById(id)) {
            throw new PetNotFoundException("Pet not found with id: " + id);
        }
        petRepository.deleteById(id);
    }

    @Override
    public List<Pet> findPetsByBreedOrderByAge(String breed) {
        return petRepository.findByBreedOrderByAgeAsc(breed);
    }

    @Override
    public double getAverageAge() {
        Double averageAge = petRepository.getAverageAge();
        return averageAge != null ? averageAge : 0;
    }

    @Override
    public Pet getOldestPet() throws PetNotFoundException {
        Pet oldestPet = petRepository.getOldestPet();
        if (oldestPet == null) {
            throw new PetNotFoundException("No pets found in the database");
        }
        return oldestPet;
    }



    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPet(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Pet updatePetName(Long id, String name) {
        Pet pet = petRepository.findById(id).orElse(null);
        if (pet != null) {
            pet.setName(name);
            return petRepository.save(pet);
        }
        return null;
    }
}