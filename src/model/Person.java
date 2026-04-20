package model;

/**
 * Name: Alex Akere, Cam Carter, Chloe Duca
 * Date: April 20, 2026
 * Description: The blueprint for any individual involved with the gym.
 * It stores the basic details that everyone shares, like a name, an ID, and an age.
 * By putting the core validation logic here—like checking if someone is too young—
 * it ensures that every person added to the system follows the same basic rules.
 */
import exception.InvalidMemberException;

public abstract class Person implements Displayable {
    protected int id;
    protected String name;
    protected int age;

    public Person(int id, String name, int age) throws InvalidMemberException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidMemberException("Name cannot be empty.");
        }
        if (age < 16) {
            throw new InvalidMemberException("Age must be at least 16 to join the gym.");
        }
        
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public abstract void displayInfo();
}
