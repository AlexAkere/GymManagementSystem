package utility;

/**
 * Name: Alex Akere, Cam Carter, Chloe Duca
 * Date: April 20, 2026
 * Description: Utility class responsible for establishing a connection to the MariaDB server.
 * It uses a centralized approach to database connectivity using the JDBC DriverManager.
 * The configuration is optimized  to ensure 
 * compatibility and bypass modern authentication issues.
 * This class serves as the backbone for all data persistence within the gym management system.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Keep the URL clean
    private static final String URL = "jdbc:mariadb://localhost:3306/gym_db";
    private static final String USER = "root"; 
    // Matches HeidiSQL password
    private static final String PASSWORD = "password"; 

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver"); 
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found! Check your Build Path.");
            throw new SQLException(e);
        }
    }
}
