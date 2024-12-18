package com.example.lab5second.repositories;

import com.example.lab5second.entities.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface HouseholdRepository extends JpaRepository<Household, String> {



    @Query("SELECT h FROM Household h LEFT JOIN FETCH h.pets WHERE h.eircode = :eircode")

    Household findByEircodeWithPets(String eircode);



    @Query("SELECT h FROM Household h WHERE h.pets IS EMPTY")

    List<Household> findHouseholdsWithNoPets();

}

