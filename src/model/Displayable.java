package model;

/**
 * Name: Alex Akere, Cam Carter, Chloe Duca
 * Date: April 20, 2026
 * Description: A contract that ensures any class implementing it knows how to show its data.
 * By using this interface, both Members and Trainers are forced to provide a way to 
 * display their details to the console. This allows the system to treat different 
 * types of people in a consistent way when printing gym records.
 */

public interface Displayable {
    void displayInfo();
}