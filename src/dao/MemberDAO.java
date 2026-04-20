package dao;

/**
 * Name: Alex Akere, Cam Carter, Chloe Duca
 * Date: April 20, 2026
 * Description: Data Access Object (DAO) manages database operations for Member entities.
 * This class facilitates CRUD functionality by executing SQL queries against the MariaDB database.
 * It uses secure SQL statements to protect data and automatically closes connections to save system resources. 
 * The class converts database rows into Member objects and ensures only valid data is processed.
 * This acts as the main bridge between the Java application and MariaDB
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utility.DatabaseConnection;
import model.Member;
import exception.InvalidMemberException; 

public class MemberDAO {

    // 1. ADD MEMBER
    public void addMember(Member member) throws SQLException {
        String sql = "INSERT INTO members (id, name, age, membership_type) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, member.getId());
            pstmt.setString(2, member.getName());
            pstmt.setInt(3, member.getAge());
            pstmt.setString(4, member.getMembershipType());
            
            pstmt.executeUpdate();
            System.out.println("Member added to database successfully!");
        }
    }

    // 2. GET ALL MEMBERS
    public List<Member> getAllMembers() throws SQLException {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                try {
                    
                    Member m = new Member(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("membership_type")
                    );
                    members.add(m);
                } catch (InvalidMemberException e) {
                    System.err.println("Skipping invalid record from DB: " + e.getMessage());
                }
            }
        }
        return members;
    }

    // 3. DELETE MEMBER
    public void deleteMember(int id) throws SQLException {
        String sql = "DELETE FROM members WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Member deleted successfully.");
            } else {
                System.out.println("No member found with ID: " + id);
            }
        }
    }
}