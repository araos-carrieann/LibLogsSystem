/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finallibrarysystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author araos
 */
public class UserLogsDAO {

    // Creates a new table named "logs" in the database to store user activity logs
    public static void createLogs() {
        try (Connection conn = DatabaseConnector.getConnection()) {
            // SQL query to create the "logs" table if it doesn't already exist
            String createTableQuery = """
                                      CREATE TABLE IF NOT EXISTS logs (
                                          logID SERIAL PRIMARY KEY,
                                          user_id_users INTEGER REFERENCES users(id),
                                          reason VARCHAR(150),
                                          fullname VARCHAR(255),
                                          login_time TIMESTAMP DEFAULT (TO_TIMESTAMP(TO_CHAR(CURRENT_TIMESTAMP, 'YYYY-MM-DD HH24:MI:SS'), 'YYYY-MM-DD HH24:MI:SS')),
                                          logout_time TIMESTAMP
                                      );""";

            try (PreparedStatement statement = conn.prepareStatement(createTableQuery)) {
                // Execute the query to create the "logs" table
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }
    }

    public static List<UserLogsDTO> getAllLogs() {
        List<UserLogsDTO> dataList = new ArrayList<>();

        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "SELECT\n"
                + "    logs.fullname,\n"
                + "    logs.reason,\n"
                + "    logs.login_time,\n"
                + "    logs.logout_time,\n"
                + "    users.studentfacultyID AS sfID,\n"
                + "    users.role AS userRole,\n"
                + "    users.program,\n"
                + "    users.yearlvl\n"
                + "FROM\n"
                + "    users\n"
                + "RIGHT JOIN\n"
                + "    logs\n"
                + "ON\n"
                + "    logs.user_id_users = users.id\n"
                + "WHERE\n"
                + "    users.role IN ('STUDENT', 'FACULTY', 'ADMIN')\n"
                + "    AND logs.login_time >= CURRENT_TIMESTAMP - INTERVAL '3 months'\n"
                + "ORDER BY\n"
                + "    logs.login_time DESC;"); // Execute the query and retrieve the ResultSet
                 ResultSet rsltSet = stmt.executeQuery()) {

            // Loop through the ResultSet and fetch data for each row
            while (rsltSet.next()) {
                String userRole = rsltSet.getString("userRole");
                String userFullname = rsltSet.getString("fullname");
                String userProgram = rsltSet.getString("program");
                String userYrlvl = rsltSet.getString("yearlvl");
                Timestamp userLogin = rsltSet.getTimestamp("login_time");
                Timestamp userLogout = rsltSet.getTimestamp("logout_time");
                String userReason = rsltSet.getString("reason");

                // Create a LogsDTO object and add it to the dataList
                UserLogsDTO data = new UserLogsDTO(userRole, userFullname, userProgram, userYrlvl, userReason, userLogin, userLogout);
                dataList.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return the list of LogsDTO containing the retrieved data
        return dataList;
    }

    public static void userLogout(String stuFaculID) {
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT id FROM users WHERE studentFacultyID = ?"); PreparedStatement updateStmt = conn.prepareStatement("UPDATE logs SET logout_time = TO_TIMESTAMP(TO_CHAR(CURRENT_TIMESTAMP, 'YYY-MM-DD HH24:MI:SS'),'YYY-MM-DD HH24:MI:SS') WHERE user_id_users = ? AND logout_time IS NULL")) {

            stmt.setString(1, stuFaculID);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                updateStmt.setInt(1, userId);
                updateStmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkLogs(String stuFaculID) {
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT id FROM users WHERE studentFacultyID = ?")) {

            stmt.setString(1, stuFaculID);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("id");

                PreparedStatement logsStmt = conn.prepareStatement("SELECT * FROM logs WHERE user_id_users = ?");
                logsStmt.setInt(1, userId);
                ResultSet logsResultSet = logsStmt.executeQuery();

                while (logsResultSet.next()) {
                    String logoutTime = logsResultSet.getString("logout_time");
                    if (logoutTime == null) {
                        return false; // Return false if any log entry has a null logoutTime
                    }
                }

                return true; // Return true only if all log entries have non-null logoutTime
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method Overloading for Filter Table Method - RESUMED
    // Method to be use when ALL filter has changed
    public List<UserLogsDTO> filterTable(String program, String yearlevel, Date start, Date end) throws SQLException {
        List<UserLogsDTO> users = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "SELECT\n"
                + "    logs.fullname,\n"
                + "    logs.reason,\n"
                + "    TO_CHAR(logs.login_time, 'YYYY-MM-DD HH24:MI:SS') AS formatted_login_time,\n"
                + "    TO_CHAR(logs.logout_time, 'YYYY-MM-DD HH24:MI:SS') AS formatted_logout_time,\n"
                + "    users.studentfacultyID AS sfID,\n"
                + "    users.role AS userRole,\n"
                + "    users.program,\n"
                + "    users.yearlvl\n"
                + "FROM\n"
                + "    users\n"
                + "RIGHT JOIN\n"
                + "    logs\n"
                + "ON\n"
                + "    logs.user_id_users = users.id\n"
                + "WHERE (logs.login_time BETWEEN ? AND ?)\n"
                + "AND (users.program = ?)\n"
                + "AND (users.yearlvl = ?)\n"
                + "ORDER BY\n"
                + "    logs.login_time DESC")) {

            // Set the parameters for the placeholders
            stmt.setDate(1, start);
            stmt.setDate(2, end);
            stmt.setString(3, program);  // Replace with the actual program value
            stmt.setString(4, yearlevel); // Replace with the actual year level value

            // Execute the query and retrieve the ResultSet
            ResultSet rsltSet = stmt.executeQuery();

            // Loop through the ResultSet and fetch data for each row
            while (rsltSet.next()) {
                String userRole = rsltSet.getString("userRole");
                String userFullname = rsltSet.getString("fullname");
                String userProgram = rsltSet.getString("program");
                String userYrlvl = rsltSet.getString("yearlvl");
                Timestamp userLogin = rsltSet.getTimestamp("formatted_login_time");
                Timestamp userLogout = rsltSet.getTimestamp("formatted_logout_time");
                String userReason = rsltSet.getString("reason");

                // Create a UserLogsDTO object and add it to the users list
                UserLogsDTO data = new UserLogsDTO(userRole, userFullname, userProgram, userYrlvl, userReason, userLogin, userLogout);
                users.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling mechanism
        }

        // Return the list of UserLogsDTO containing the retrieved data
        return users;
    }

    public List<UserLogsDTO> filterTable(String text, Date start, Date end) throws SQLException {
        List<UserLogsDTO> users = new ArrayList<>();

        // Filter by program
        if (!"PROGRAM".equals(text)) {
            String programSql = """
                                SELECT
                                    logs.fullname,
                                    logs.reason,
                                    TO_CHAR(logs.login_time, 'YYYY-MM-DD HH24:MI:SS') AS formatted_login_time,
                                    TO_CHAR(logs.logout_time, 'YYYY-MM-DD HH24:MI:SS') AS formatted_logout_time,
                                    users.studentfacultyID AS sfID,
                                    users.role AS userRole,
                                    users.program,
                                    users.yearlvl
                                FROM
                                    users
                                RIGHT JOIN
                                    logs
                                ON
                                    logs.user_id_users = users.id
                                WHERE (users.program = ?)
                                AND (logs.login_time BETWEEN ? AND ?)
                                ORDER BY
                                    logs.login_time DESC;""";
            try (Connection conn = DatabaseConnector.getConnection()) {
                PreparedStatement pstmt = conn.prepareStatement(programSql);

                pstmt.setString(1, text);
                pstmt.setDate(2, start);
                pstmt.setDate(3, end);

                ResultSet rsltSet = pstmt.executeQuery();

                // Loop through the ResultSet and fetch data for each row
                while (rsltSet.next()) {
                    String userRole = rsltSet.getString("userRole");
                    String userFullname = rsltSet.getString("fullname");
                    String userProgram = rsltSet.getString("program");
                    String userYrlvl = rsltSet.getString("yearlvl");
                    Timestamp userLogin = rsltSet.getTimestamp("formatted_login_time");
                    Timestamp userLogout = rsltSet.getTimestamp("formatted_logout_time");
                    String userReason = rsltSet.getString("reason");

                    // Create a UserLogsDTO object and add it to the users list
                    UserLogsDTO data = new UserLogsDTO(userRole, userFullname, userProgram, userYrlvl, userReason, userLogin, userLogout);
                    users.add(data);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle the exception according to your application's error handling mechanism
            }
        }

        // Filter by year level
        if (!"YEAR LEVEL".equals(text)) {
            String yearLvlSql = """
            SELECT
                logs.fullname,
                logs.reason,
                TO_CHAR(logs.login_time, 'YYYY-MM-DD HH24:MI:SS') AS formatted_login_time,
                TO_CHAR(logs.logout_time, 'YYYY-MM-DD HH24:MI:SS') AS formatted_logout_time,
                users.studentfacultyID AS sfID,
                users.role AS userRole,
                users.program,
                users.yearlvl
            FROM
                users
            RIGHT JOIN
                logs
            ON
                logs.user_id_users = users.id
            WHERE (logs.login_time BETWEEN ? AND ?)
            AND (users.yearlvl = ?)
            ORDER BY
                logs.login_time DESC
        """;
            try (Connection conn = DatabaseConnector.getConnection()) {
                PreparedStatement pstmt = conn.prepareStatement(yearLvlSql);

                pstmt.setDate(1, start);
                pstmt.setDate(2, end);
                pstmt.setString(3, text);

                ResultSet rsltSet = pstmt.executeQuery();

                // Loop through the ResultSet and fetch data for each row
                while (rsltSet.next()) {
                    String userRole = rsltSet.getString("userRole");
                    String userFullname = rsltSet.getString("fullname");
                    String userProgram = rsltSet.getString("program");
                    String userYrlvl = rsltSet.getString("yearlvl");
                    Timestamp userLogin = rsltSet.getTimestamp("formatted_login_time");
                    Timestamp userLogout = rsltSet.getTimestamp("formatted_logout_time");
                    String userReason = rsltSet.getString("reason");

                    // Create a UserLogsDTO object and add it to the users list
                    UserLogsDTO data = new UserLogsDTO(userRole, userFullname, userProgram, userYrlvl, userReason, userLogin, userLogout);
                    users.add(data);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle the exception according to your application's error handling mechanism
            }
        }

        // Return the list of UserLogsDTO containing the retrieved data
        return users;
    }

    public List<UserLogsDTO> filterTable(Date start, Date end) throws SQLException {
        List<UserLogsDTO> users = new ArrayList<>();
        String sql = """
                SELECT
                    logs.fullname,
                    logs.reason,
                    TO_CHAR(logs.login_time, 'YYYY-MM-DD HH24:MI:SS') AS formatted_login_time,
                    TO_CHAR(logs.logout_time, 'YYYY-MM-DD HH24:MI:SS') AS formatted_logout_time,
                    users.studentfacultyID AS sfID,
                    users.role AS userRole,
                    users.program,
                    users.yearlvl
                FROM
                    users
                RIGHT JOIN
                    logs
                ON
                    logs.user_id_users = users.id
                WHERE (logs.login_time BETWEEN ? AND ?)
                ORDER BY
                    logs.login_time DESC
                """;

        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setDate(1, start);
            pstmt.setDate(2, end);

            ResultSet rsltSet = pstmt.executeQuery();

            // Iterate over the result set and create UserLogsDTO objects
            while (rsltSet.next()) {
                String userRole = rsltSet.getString("userRole");
                String userFullname = rsltSet.getString("fullname");
                String userProgram = rsltSet.getString("program");
                String userYrlvl = rsltSet.getString("yearlvl");
                Timestamp userLogin = rsltSet.getTimestamp("formatted_login_time");
                Timestamp userLogout = rsltSet.getTimestamp("formatted_logout_time");
                String userReason = rsltSet.getString("reason");

                // Create a UserLogsDTO object and add it to the users list
                UserLogsDTO data = new UserLogsDTO(userRole, userFullname, userProgram, userYrlvl, userReason, userLogin, userLogout);
                users.add(data);
            }
        }

        return users;
    }

    public int recordCount() throws SQLException {
        String sql = "SELECT COUNT(*) FROM users RIGHT JOIN logs ON logs.user_id_users = users.id";
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }

    public int recordCount(String program, String yearlevel, Date start, Date end) throws SQLException {
        String sql = "SELECT COUNT(*) "
                + "FROM users "
                + "RIGHT JOIN logs ON logs.user_id_users = users.id "
                + "WHERE users.program = ? "
                + "AND users.yearlvl = ? "
                + "AND logs.login_time BETWEEN ? AND ?";

        try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, program);
            pstmt.setString(2, yearlevel);
            pstmt.setDate(3, new java.sql.Date(start.getTime()));
            pstmt.setDate(4, new java.sql.Date(end.getTime()));

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            // Handle the exception appropriately, e.g., log it or throw a custom exception
            e.printStackTrace();
        }
        return 0;
    }

    public int recordCount(String text, Date start, Date end) throws SQLException {
        int count = 0;

        // Filter by program
        if (!"PROGRAM".equals(text)) {
            String programSql = """
            SELECT COUNT(*)
            FROM users 
            RIGHT JOIN logs ON logs.user_id_users = users.id 
            WHERE (logs.login_time BETWEEN ? AND ?) 
            AND (users.program = ?)
        """;
            try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement pstmt = conn.prepareStatement(programSql)) {
                pstmt.setDate(1, start);
                pstmt.setDate(2, end);
                pstmt.setString(3, text);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        count += rs.getInt(1);
                    }
                }
            }
        }

        // Filter by year level
        if (!"YEAR LEVEL".equals(text)) {
            String yearLvlSql = """
            SELECT COUNT(*) 
            FROM users
            RIGHT JOIN logs ON logs.user_id_users = users.id
            WHERE (logs.login_time BETWEEN ? AND ?)
            AND (yearlvl = ?)
        """;
            try (Connection conn = DatabaseConnector.getConnection(); PreparedStatement pstmt = conn.prepareStatement(yearLvlSql)) {
                pstmt.setDate(1, start);
                pstmt.setDate(2, end);
                pstmt.setString(3, text);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        count += rs.getInt(1);
                    }
                }
            }
        }

        return count;
    }

    public int recordCount(Date start, Date end) throws SQLException {
        String sql = """
                     SELECT COUNT(*) 
                     FROM users
                     RIGHT JOIN logs ON logs.user_id_users = users.id
                     WHERE (logs.login_time BETWEEN ? AND ?);""";
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, start);
            pstmt.setDate(2, end);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }
}
