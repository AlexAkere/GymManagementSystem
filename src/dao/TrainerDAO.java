package dao;


import java.sql.*;
import exception.InvalidMemberException;
import java.util.ArrayList;
import java.util.List;
import model.Trainer;
import utility.DatabaseConnection;

public class TrainerDAO {

    public void addTrainer(Trainer trainer) {
        String sql = "INSERT INTO trainers (id, name, age, specialty) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, trainer.getId());
            stmt.setString(2, trainer.getName());
            stmt.setInt(3, trainer.getAge());
            stmt.setString(4, trainer.getSpecialty());

            stmt.executeUpdate();
            System.out.println("Trainer added!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Trainer> getAllTrainers() {
        List<Trainer> trainers = new ArrayList<>();
        String sql = "SELECT * FROM trainers";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

        	while (rs.next()) {
        	    try {
        	        Trainer t = new Trainer(
        	            rs.getInt("id"),
        	            rs.getString("name"),
        	            rs.getInt("age"),
        	            rs.getString("specialty")
        	        );
        	        trainers.add(t);
        	    } catch (InvalidMemberException e) {
        	        System.err.println("Skipping invalid trainer record: " + e.getMessage());
        	    }
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trainers;
    }

    public void updateTrainer(Trainer trainer) {
        String sql = "UPDATE trainers SET name = ?, age = ?, specialty = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, trainer.getName());
            stmt.setInt(2, trainer.getAge());
            stmt.setString(3, trainer.getSpecialty());
            stmt.setInt(4, trainer.getId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Trainer updated successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTrainer(int id) {
        String sql = "DELETE FROM trainers WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Trainer deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}