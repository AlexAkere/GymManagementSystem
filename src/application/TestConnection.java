package application;

/**
 * Name: Alex Akere, Chloe Duca, Cam Carter
 * Date: April 20, 2026
 * Description: A class used to verify that Java can talk to MariaDB.
 * It runs an automated script to "knock on the door" of the database, add test data, 
 * and read it back to ensure the connection is stable. This was used to troubleshoot 
 * the system before opening it up to real users in the Main menu.
 */
import java.sql.Connection;
import utility.DatabaseConnection;

public class TestConnection {

    public static void main(String[] args) {
        System.out.println("Attempting to connect to the database...");

        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Success! The Gym Management System is connected to MariaDB.");
            } else {
                System.out.println("Failed to establish a connection.");
            }
        } catch (Exception e) {
            System.err.println("Database Connection Error!");
            e.printStackTrace();
        }
    }
}