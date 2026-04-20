This is a Java-based desktop application designed to manage gym members and trainers. It’s built with a focus on Object-Oriented Programming (OOP) and connects to a MariaDB database to ensure that all data is saved even after you close the program.

Key Features
Interactive Menu: Add or view trainers and members directly through the console.

Smart Validation: The system ensures all gym users are at least 16 years old using custom exception handling.

Database Driven: All records are stored in a gym_db schema using JDBC.

How to Set Up
Database: Run the included gym_db_setup.sql script in HeidiSQL to build the tables.

Credentials: The app connects using User: root and Password: password.

Drivers: Ensure you have the MariaDB Connector/J 2.7.x driver in your Java Build Path to avoid connection errors.

Submission Checklist
 Full Java Source Code (src)
 Database SQL Setup Script
 Sample Output / Testing Report
Design Document (UML & Class Descriptions)
