/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finallibrarysystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author araos
 */
public class AccountDAO {

    public static String updateAccount(int id, String role, String stuFaculID, String firstName, String lastName, String email, String program, String yrLvl) {
        String message = null;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement selectStmt = conn.prepareStatement("SELECT * FROM users WHERE studentFacultyID = ? AND id <> ?"); PreparedStatement updateStmt = conn.prepareStatement("UPDATE users SET studentFacultyID = ?, role = ?, firstName = ?, lastName = ?, email = ?, program = ?, yearLvl = ? WHERE id = ?")) {

            // Set parameters for the SELECT statement
            selectStmt.setString(1, stuFaculID);
            selectStmt.setInt(2, id);

            // Execute the SELECT statement
            ResultSet resultSet = selectStmt.executeQuery();

            // If a row is returned, display a message indicating that the studentFacultyID already exists
            if (resultSet.next()) {
                message = "The studentFacultyID already exists.";
            } else {
                // Set parameters for the UPDATE statement
                updateStmt.setString(1, stuFaculID);
                updateStmt.setString(2, role);
                updateStmt.setString(3, firstName);
                updateStmt.setString(4, lastName);
                updateStmt.setString(5, email);
                updateStmt.setString(6, program);
                updateStmt.setString(7, yrLvl);
                updateStmt.setInt(8, id);

                // Execute the UPDATE statement
                updateStmt.executeUpdate();

                message = "Account updated successfully";
                System.out.println("Record updated successfully.");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return message;
    }

// Deactivates the account of a user with the specified studentID
    public static void deleteAcct(String studentID) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // SQL update query to set the status of the user to 'DEACTIVATE'
            String updateQuery = "UPDATE users SET status = 'DEACTIVATE' WHERE studentfacultyID = ?";

            try (PreparedStatement statement = conn.prepareStatement(updateQuery)) {
                // Set the studentID as a parameter in the query
                statement.setString(1, studentID);
                // Execute the update query to deactivate the account
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
