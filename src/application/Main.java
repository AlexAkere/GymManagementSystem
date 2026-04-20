package application;

/**
 * Name: Alex Akere
 * Date: April 20, 2026
 * Description: The primary entry point and controller for the Gym Management System.
 * This class features an interactive console-based menu driven by a while loop and switch logic.
 * It coordinates communication between the user, the DAOs, and the model classes 
 * to perform real-time data management. Comprehensive error handling is implemented 
 * to catch and report SQL issues and custom business logic exceptions.
 */

import dao.MemberDAO;
import dao.TrainerDAO;
import exception.InvalidMemberException;
import model.Member;
import model.Trainer;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * The entry point for the Gym Management System.
 * This class handles the interactive menu and user input.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberDAO memberDAO = new MemberDAO();
        TrainerDAO trainerDAO = new TrainerDAO();

        System.out.println("--- Welcome to the Gym Management System ---");

        boolean running = true;
        while (running) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Add Trainer");
            System.out.println("2. View Trainers");
            System.out.println("3. Add Member");
            System.out.println("4. View Members");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            // Check if input is an integer to avoid crashes
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number (1-5).");
                scanner.next(); 
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Trainer ID: ");
                        int tId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String tName = scanner.nextLine();
                        System.out.print("Enter Age: ");
                        int tAge = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Specialty: ");
                        String specialty = scanner.nextLine();

                        Trainer trainer = new Trainer(tId, tName, tAge, specialty);
                        trainerDAO.addTrainer(trainer);
                        break;

                    case 2:
                        System.out.println("\n--- Current Trainers in Database ---");
                        for (Trainer t : trainerDAO.getAllTrainers()) {
                            t.displayInfo(); 
                        }
                        break;

                    case 3:
                        System.out.print("Enter Member ID: ");
                        int mId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String mName = scanner.nextLine();
                        System.out.print("Enter Age: ");
                        int mAge = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Membership Type: ");
                        String type = scanner.nextLine();

                        Member member = new Member(mId, mName, mAge, type);
                        memberDAO.addMember(member);
                        break;

                    case 4:
                        System.out.println("\n--- Current Members in Database ---");
                        for (Member m : memberDAO.getAllMembers()) {
                            m.displayInfo(); 
                        }
                        break;

                    case 5:
                        running = false;
                        System.out.println("Exiting program. Data has been saved to MariaDB.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please select 1-5.");
                }
            } catch (InvalidMemberException e) {
                System.err.println("Validation Error: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Database Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }
}