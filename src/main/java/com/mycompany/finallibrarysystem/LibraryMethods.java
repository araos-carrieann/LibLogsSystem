/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finallibrarysystem;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author araos
 */
public class LibraryMethods {

    public static boolean registerUser(String status, String role, String studentFacultyID, String fname, String lname, String email, String program, String yrLvl) {
        boolean success = false;
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Create the table if it doesn't exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, status VARCHAR(10) NOT NULL, studentFacultyID VARCHAR(10) NOT NULL, role VARCHAR(10) NOT NULL, firstName VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, email VARCHAR(50) NOT NULL, program VARCHAR(30), yearLvl VARCHAR(10))";
            stmt.executeUpdate(createTableQuery);

            // Prepare the SELECT query with parameters
            String selectQuery = "SELECT * FROM users WHERE studentFacultyID = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
            selectStmt.setString(1, studentFacultyID);

            // Execute the SELECT query
            ResultSet resultSet = selectStmt.executeQuery();

            // If a row is returned, set success to false
            if (resultSet.next()) {
                success = false;
            } else {
                // If no rows are returned, proceed with the insert operation
                String insertQuery = "INSERT INTO users (status, studentFacultyID, role, firstName, lastName, email, program, yearLvl) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, status);
                insertStmt.setString(2, studentFacultyID);
                insertStmt.setString(3, role);
                insertStmt.setString(4, fname);
                insertStmt.setString(5, lname);
                insertStmt.setString(6, email);
                insertStmt.setString(7, program);
                insertStmt.setString(8, yrLvl);

                // Execute the INSERT query
                insertStmt.executeUpdate();

                success = true;
                System.out.println("Record inserted successfully.");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return success;
    }

    // Retrieves user information based on the provided student/faculty ID from the database
    public static String getInfo(String stuFaculID) {
        // Initialize variables to store user information
        String id = "";
        String studFaculID = "";
        String program = "";
        String yearLevel = "";

        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE studentfacultyID = ?")) {
            // Set the student/faculty ID as a parameter in the SQL query
            stmt.setString(1, stuFaculID);
            // Execute the query and retrieve the result set
            ResultSet rsltSet = stmt.executeQuery();

            if (rsltSet.next()) {
                // Extract user information from the result set
                id = rsltSet.getString("id");
                studFaculID = rsltSet.getString("studentfacultyID");
                String fname = rsltSet.getString("firstName");
                String lname = rsltSet.getString("lastName");
                String email = rsltSet.getString("email");
                program = rsltSet.getString("program");
                yearLevel = rsltSet.getString("yearLvl");

                // Concatenate user information into a single string and return it
                return id + "," + studFaculID + "," + fname + "," + lname + "," + email + "," + program + "," + yearLevel;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return an empty string if no matching user information found
        return "";
    }

    public static String getUserDetails(String stuFaculID) {
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE studentfacultyID = ?")) {

            // Set the student/faculty ID as a parameter in the SQL query
            stmt.setString(1, stuFaculID);

            // Execute the query and retrieve the result set
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                String status = resultSet.getString("status");
                String userRole = resultSet.getString("role");
                String studFaculID = resultSet.getString("studentfacultyID");
                String fname = resultSet.getString("firstName");
                String lname = resultSet.getString("lastName");

                // Concatenate user details into a single string and return it
                return status + "," + userRole + "," + studFaculID + "," + fname + "," + lname;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return "false" if no matching user details found
        return "false";
    }

    // Logs user login activity in the database based on the provided student/faculty ID, full name, and password
    public static void logUserLogin(String stuFaculID, String fullName, String reason) {
        // Create the "logs" table if it doesn't exist
        UserLogsDAO.createLogs();
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Retrieve the user ID from the users table along with status and hashed password
            String selectUserIdQuery = "SELECT id FROM users WHERE studentFacultyID = ?";

            try (PreparedStatement selectUserIdStatement = conn.prepareStatement(selectUserIdQuery)) {
                // Set the value of the stuFaculID parameter in the query
                selectUserIdStatement.setString(1, stuFaculID);

                try (ResultSet rs = selectUserIdStatement.executeQuery()) {
                    // Check if there is at least one row in the result set
                    if (rs.next()) {
                        // Retrieve the user ID from the result set
                        int userId = rs.getInt("id");
                        // Insert a log entry for successful login
                        String insertQuery = "INSERT INTO logs (user_id_users, fullname, reason, login_time) VALUES (?, ?, ?, DEFAULT)";
                        try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery)) {
                            insertStatement.setInt(1, userId);
                            insertStatement.setString(2, fullName);
                            insertStatement.setString(3, reason);
                            // Use the default value for login_time (current timestamp) in the query
                            insertStatement.executeUpdate();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            // Consider using a logging framework to log exceptions
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
    }

    // Retrieves a list of all active student account data from the database
    public static List<AccountsDTO> getAllStudentDatas() {
        // Create an empty list to store the retrieved student data
        List<AccountsDTO> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE role = 'STUDENT' AND status = 'ACTIVE';"); ResultSet rsltSet = stmt.executeQuery()) {

            // Iterate through the result set to retrieve data for each student
            while (rsltSet.next()) {
                // Extract relevant information for each student
                String studentID = rsltSet.getString("studentfacultyID");
                String userEmail = rsltSet.getString("email");
                String userFname = rsltSet.getString("firstName");
                String userLname = rsltSet.getString("lastName");
                String userProgram = rsltSet.getString("program");
                String userYrLvl = rsltSet.getString("yearLvl");

                // Create an AccountDTO object and add it to the list
                AccountsDTO data = new AccountsDTO(studentID, userEmail, userFname, userLname, userProgram, userYrLvl);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return the list of student account data
        return dataList;
    }

// Retrieves a list of all active faculty account data from the database
    public static List<UserLogsDTO> getAllFacultiesDatas() {
        // Create an empty list to store the retrieved faculty data
        List<UserLogsDTO> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE role = 'FACULTY' AND status = 'ACTIVE';"); ResultSet rsltSet = stmt.executeQuery()) {

            // Iterate through the result set to retrieve data for each faculty member
            while (rsltSet.next()) {
                // Extract relevant information for each faculty member
                String userFacultyID = rsltSet.getString("studentfacultyID");
                String userEmail = rsltSet.getString("email");
                String userFname = rsltSet.getString("firstName");
                String userLname = rsltSet.getString("lastName");

                // Create an AccountDTO object and add it to the list
                UserLogsDTO data = new UserLogsDTO(userFacultyID, userEmail, userFname, userLname);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return the list of faculty account data
        return dataList;
    }

    public static List<AccountsDTO> getAllAdminDatas() {
        List<AccountsDTO> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE role = 'ADMIN' AND status = 'ACTIVE';"); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                int id = rsltSet.getInt("id");
                String facultyID = rsltSet.getString("studentfacultyID");
                String userEmail = rsltSet.getString("email");
                String userFname = rsltSet.getString("firstName");
                String userLname = rsltSet.getString("lastName");

                AccountsDTO data = new AccountsDTO(id, facultyID, userFname, userLname, userEmail);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return dataList;
    }

    //Comboxes
    // Adds a program option to the program combobox in the database
    public static void programComboBox(String prog) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Create the "program" table if it doesn't exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS program (program VARCHAR(100))";

            try (PreparedStatement statement = conn.prepareStatement(createTableQuery)) {
                // Execute the query to create the "program" table
                statement.execute();
            }

            // Insert the new program option into the "program" table
            String insertProgramQuery = "INSERT INTO program (program) VALUES (?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertProgramQuery)) {
                // Set the program name as a parameter in the insert query
                insertStatement.setString(1, prog);
                // Execute the query to insert the program into the table
                insertStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
    }
    // Retrieves the content of the program combobox from the "program" table in the database

    public static List<AccountsDTO> programComboContent() {
        // Create an empty list to store the retrieved program options
        List<AccountsDTO> programList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM program"); ResultSet rsltSet = stmt.executeQuery()) {

            // Iterate through the result set to retrieve program options
            while (rsltSet.next()) {
                // Extract the program option from the result set
                String program = rsltSet.getString("program");

                // Create an AccountDTO object with the program option and "null" values for unused fields
                AccountsDTO data = new AccountsDTO(program, "null");
                programList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return the list of program options
        return programList;
    }

    // Deletes a program option from the "program" table in the database
    public static void deleteProgram(String program) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Prepare the SQL delete query
            String sql = "DELETE FROM program WHERE program = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            // Set the program name as a parameter in the delete query
            statement.setString(1, program);
            // Execute the delete query to remove the program option from the table
            statement.executeUpdate();
            System.out.println("Row deleted successfully.");
        } catch (SQLException e) {
            // Handle the exception by printing the error message
            System.out.println("Error deleting row from the database: " + e.getMessage());
        }
    }

    // Adds a year level option to the year level combobox in the database
    public static void yearLevelComboBox(String lvl) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Create the "yearLevel" table if it doesn't exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS yearLevel (yearLevel VARCHAR(10))";
            try (PreparedStatement statement = conn.prepareStatement(createTableQuery)) {
                // Execute the query to create the "yearLevel" table
                statement.execute();
            }
            // Insert the new year level option into the "yearLevel" table
            String insertYrLvlQuery = "INSERT INTO yearLevel (yearLevel) VALUES (?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertYrLvlQuery)) {
                // Set the year level as a parameter in the insert query
                insertStatement.setString(1, lvl);
                // Execute the query to insert the year level into the table
                insertStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
    }

    // Retrieves the content of the year level combobox from the "yearLevel" table in the database
    public static List<AccountsDTO> yearlvlComboContent() {
        // Create an empty list to store the retrieved year level options
        List<AccountsDTO> yearLevelList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM yearLevel"); ResultSet rsltSet = stmt.executeQuery()) {
            // Iterate through the result set to retrieve year level options
            while (rsltSet.next()) {
                // Extract the year level from the result set
                String yrlvl = rsltSet.getString("yearLevel");
                // Create an AccountDTO object with the year level and "null" values for unused fields
                AccountsDTO data = new AccountsDTO("null", yrlvl);
                yearLevelList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
        // Return the list of year level options
        return yearLevelList;
    }

    // Deletes a year level option from the "yearLevel" table in the database
    public static void deleteYearLvl(String yrLvl) {
        try (Connection conn = DatabaseConnector.getConnection(); Statement stmt = conn.createStatement()) {
            // Prepare the SQL delete query
            String sql = "DELETE FROM yearLevel WHERE yearLevel = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            // Set the year level as a parameter in the delete query
            statement.setString(1, yrLvl);
            // Execute the delete query to remove the year level option from the table
            statement.executeUpdate();
            System.out.println("Row deleted successfully.");
        } catch (SQLException e) {
            // Handle the exception by printing the error message
            System.out.println("Error deleting row from the database: " + e.getMessage());
        }
    }

    public static int getUserID(String studentFacultyID) {
        int id = 0;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT id FROM users WHERE studentFacultyID = '" + studentFacultyID + "'"); ResultSet rsltSet = stmt.executeQuery()) {

            while (rsltSet.next()) {
                id = rsltSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return id;
    }

    // Retrieves a list of AccountDTO objects representing users with the most logs from the "logs" table in the database
    public static List<AccountsDTO> mostLogs() {
        // Create an empty list to store user logs
        List<AccountsDTO> userLogs = new ArrayList<>();

        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement selectStmt = conn.prepareStatement("SELECT users.role, logs.fullname, COUNT(*) AS total_logs "
                + "FROM logs "
                + "JOIN users ON logs.user_id_users = users.id "
                + "GROUP BY users.role, logs.fullname "
                + "ORDER BY total_logs DESC "
                + "LIMIT 5"); ResultSet resultSet = selectStmt.executeQuery()) {

            // Iterate through the result set to retrieve users with the most logs
            while (resultSet.next()) {
                // Retrieve the role, fullname, and total_logs from the ResultSet
                String role = resultSet.getString("role");
                String fullname = resultSet.getString("fullname");
                int totalLogs = resultSet.getInt("total_logs");

                // Create a new instance of AccountDTO and add it to the userLogs list
                AccountsDTO userLog = new AccountsDTO(role, fullname, null, String.valueOf(totalLogs));
                userLogs.add(userLog);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return the list of AccountDTO objects representing users with the most logs
        return userLogs;
    }

    public static List<UserLogsDTO> activeUsers() {
        List<UserLogsDTO> userActive = new ArrayList<>();
        String sqlQuery = "SELECT logs.fullname, logs.reason, logs.login_time, logs.logout_time, "
                + "users.studentfacultyID AS sfID, "
                + "users.program, users.yearlvl "
                + "FROM logs "
                + "LEFT JOIN users ON logs.user_id_users = users.id "
                + "WHERE logs.logout_time IS NULL";

        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlQuery); ResultSet resultSet = stmt.executeQuery()) {

            // Loop through the ResultSet and fetch data for each row
            while (resultSet.next()) {
                String userFullname = resultSet.getString("fullname");
                String userProgram = resultSet.getString("program");
                String userYrlvl = resultSet.getString("yearlvl");

                // Create a LogsDTO object and populate it with the retrieved data
                UserLogsDTO onlineUser = new UserLogsDTO(userFullname, userProgram, userYrlvl);
                userActive.add(onlineUser);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return the list of LogsDTO objects representing active users
        return userActive;
    }

    // Retrieves the visitor ID from the "visitors" table based on the given code identity
    public static int getVisitorID(String codeIdentity) {
        int id = 0;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT id FROM visitors WHERE codeidentity = '" + codeIdentity + "'"); ResultSet rsltSet = stmt.executeQuery()) {

            // Retrieve the visitor ID from the result set
            while (rsltSet.next()) {
                id = rsltSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return id;
    }

// Retrieves the student or faculty ID from the "users" table based on the given email
    public static String getStudentFacultyID(String email) {
        String studentFacultyID = null;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT studentFacultyID FROM users WHERE email = '" + email + "'"); ResultSet rsltSet = stmt.executeQuery()) {

            // Retrieve the student or faculty ID from the result set
            while (rsltSet.next()) {
                studentFacultyID = rsltSet.getString("studentFacultyID");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return studentFacultyID;
    }

    // Retrieves the total number of rows in the "users" table
    public static int getTotalUserRows() {
        int totalRows = 0;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS total_rows FROM users"); ResultSet rs = stmt.executeQuery()) {

            // Retrieve the total number of rows from the result set
            if (rs.next()) {
                totalRows = rs.getInt("total_rows");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return totalRows;
    }

    // Retrieves the total number of active users (users with a null logout_time) from the "logs" table
    public static int getTotalActiveUser() {
        int totalActive = 0;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS total_active FROM logs WHERE logout_time IS NULL;"); ResultSet rs = stmt.executeQuery()) {

            // Retrieve the total number of active users from the result set
            if (rs.next()) {
                totalActive = rs.getInt("total_active");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        return totalActive;
    }

    // Retrieves the login time of a specific student based on their studentFacultyID
    public String getTimeLogin(String studentFacultyID) {
        String loginTime = null;
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "SELECT login_time FROM logs "
                + "WHERE user_id_users = (SELECT id FROM users WHERE studentFacultyID = ?) "
                + "AND logout_time IS NULL")) {

            // Set the studentFacultyID as a parameter in the query
            stmt.setString(1, studentFacultyID);

            try (ResultSet rs = stmt.executeQuery()) {
                // Retrieve the login time from the result set
                if (rs.next()) {
                    loginTime = rs.getString("login_time");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
        return loginTime;
    }

    // Customizes the appearance of a JTable's header
    public void Table(JTable table) {
        // Set font and appearance for table header
        table.getTableHeader().setFont(new Font("Segui UI", Font.BOLD, 14));
        // Set height of the table header
        table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getPreferredSize().width, 30));
    }

}
