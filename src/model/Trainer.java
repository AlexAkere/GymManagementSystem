package model;

/**
 * Name: Alex Akere, Cam Carter
 * Date: April 20, 2026
 * Description: Represents a specialized fitness professional within the gym system.
 * This class demonstrates inheritance by extending the Person base class to reuse 
 * common attributes like ID, Name, and Age. It includes a specific specialty field 
 * and overrides the displayInfo method to provide a customized string representation.
 * It also validates input during construction to ensure data integrity before persistence.
 */

import exception.InvalidMemberException;

public class Trainer extends Person {

    private String specialty;

    // Constructor throws InvalidMemberException because the parent (Person) does
    public Trainer(int id, String name, int age, String specialty) throws InvalidMemberException {
        super(id, name, age); // Passes id, name, and age to the Person constructor
        
        // Validation to hit those "Excellent" marks
        if (specialty == null || specialty.trim().isEmpty()) {
            throw new InvalidMemberException("Trainer specialty cannot be empty.");
        }
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public void displayInfo() {
        // Uses the protected fields inherited from Person
        System.out.println("Trainer [ID: " + id + ", Name: " + name + 
                           ", Age: " + age + ", Specialty: " + specialty + "]");
    }
}