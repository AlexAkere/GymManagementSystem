-- CPRG211 Final Project Database Setup
-- Group: Alex Akere, Chloe Duca, Cam Carter, Hamza Al-Zubairi

CREATE DATABASE IF NOT EXISTS gym_db;
USE gym_db;

CREATE TABLE IF NOT EXISTS trainers (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    specialty VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS members (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    membership_type VARCHAR(100) NOT NULL
);