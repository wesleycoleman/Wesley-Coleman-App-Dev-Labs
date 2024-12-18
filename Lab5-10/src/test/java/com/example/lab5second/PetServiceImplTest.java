package com.example.lab5second;

import com.example.lab5second.entities.Pet;
import com.example.lab5second.exceptions.PetNotFoundException;
import com.example.lab5second.repositories.PetRepository;
import com.example.lab5second.services.PetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetServiceImplTest {

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetServiceImpl petService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPet_ValidPet_ReturnsSavedPet() {
        Pet pet = new Pet();
        pet.setName("Buddy");
        when(petRepository.save(pet)).thenReturn(pet);

        Pet result = petService.createPet(pet);

        assertEquals(pet, result);
        verify(petRepository).save(pet);
    }

    @Test
    void createPet_InvalidPet_ThrowsException() {
        Pet pet = new Pet();
        assertThrows(IllegalArgumentException.class, () -> petService.createPet(pet));
    }

    @Test
    void getPetById_ExistingId_ReturnsPet() throws PetNotFoundException {
        Long id = 1L;
        Pet pet = new Pet();
        when(petRepository.findById(id)).thenReturn(Optional.of(pet));

        Pet result = petService.getPetById(id);

        assertEquals(pet, result);
    }

    @Test
    void getPetById_NonExistingId_ThrowsException() {
        Long id = 1L;
        when(petRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(PetNotFoundException.class, () -> petService.getPetById(id));
    }

    @Test
    void deletePetById_ExistingId_DeletesPet() throws PetNotFoundException {
        Long id = 1L;
        when(petRepository.existsById(id)).thenReturn(true);

        petService.deletePetById(id);

        verify(petRepository).deleteById(id);
    }

    @Test
    void deletePetById_NonExistingId_ThrowsException() {
        Long id = 1L;
        when(petRepository.existsById(id)).thenReturn(false);

        assertThrows(PetNotFoundException.class, () -> petService.deletePetById(id));
    }

    @Test
    void findPetsByBreedOrderByAge_ReturnsOrderedList() {
        String breed = "Labrador";
        List<Pet> pets = Arrays.asList(new Pet(), new Pet());
        when(petRepository.findByBreedOrderByAgeAsc(breed)).thenReturn(pets);

        List<Pet> result = petService.findPetsByBreedOrderByAge(breed);

        assertEquals(pets, result);
    }

    @Test
    void getAverageAge_ReturnsCorrectAverage() {
        when(petRepository.getAverageAge()).thenReturn(3.5);

        double result = petService.getAverageAge();

        assertEquals(3.5, result, 0.001);
    }

    @Test
    void getOldestPet_ReturnsOldestPet() throws PetNotFoundException {
        Pet oldestPet = new Pet();
        when(petRepository.getOldestPet()).thenReturn(oldestPet);

        Pet result = petService.getOldestPet();

        assertEquals(oldestPet, result);
    }

    @Test
    void getOldestPet_NoPetsFound_ThrowsException() {
        when(petRepository.getOldestPet()).thenReturn(null);

        assertThrows(PetNotFoundException.class, () -> petService.getOldestPet());
    }
}
