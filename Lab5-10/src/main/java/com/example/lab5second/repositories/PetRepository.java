package com.example.lab5second.repositories;

import com.example.lab5second.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByBreedOrderByAgeAsc(String breed);

    @Query("SELECT AVG(p.age) FROM Pet p")
    Double getAverageAge();

    @Query("SELECT p FROM Pet p WHERE p.age = (SELECT MAX(age) FROM Pet)")
    Pet getOldestPet();
}
