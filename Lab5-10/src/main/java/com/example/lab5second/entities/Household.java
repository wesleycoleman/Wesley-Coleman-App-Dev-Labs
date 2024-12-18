package com.example.lab5second.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "household")
public class Household {
    @Id
    private String eircode;

    @Column(nullable = false)
    private int number_of_occupants;

    @Column(nullable = false)
    private int max_number_of_occupants;

    @Column(nullable = false)
    private boolean owner_occupied;

    @Column
    private int number_of_pets;


    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Indicates this side of the relationship is the parent
    private List<Pet> pets;
}
