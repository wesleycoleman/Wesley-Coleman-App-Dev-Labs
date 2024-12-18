package com.example.lab5second.exceptions;

public class PetNotFoundException extends Exception {
    public PetNotFoundException(String message) {
        super("Pet not found");
    }
}
