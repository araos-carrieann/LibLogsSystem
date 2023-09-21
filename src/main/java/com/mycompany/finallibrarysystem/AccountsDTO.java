/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finallibrarysystem;

/**
 *
 * @author araos
 */
public class AccountsDTO {

    private int userID;
    private int logsID;
    private String mostLogs;
    private String studentfacultyID;
    private String status;
    private String role;
    private String firstName;
    private String lastName;
    private String fullname;
    private String email;
    private String program;
    private String yrlvl;
    private String userLogin;
    private String userLogout;
    private String reason;

    public AccountsDTO(String reason) {
        this.reason = reason;
    }
    

    public AccountsDTO(int logsID, String fullname, String userLogin, String userLogout) {
        this.logsID = logsID;
        this.fullname = fullname;
        this.userLogin = userLogin;
        this.userLogout = userLogout;
    }

    public AccountsDTO(String program, String yrlvl) {
        this.program = program;
        this.yrlvl = yrlvl;
    }

    public AccountsDTO(String role, String fullname, String logsDuration, String mostLogs) {
        this.role = role;
        this.fullname = fullname;
        this.mostLogs = mostLogs;
    }

    public AccountsDTO(int userID, String studentfacultyID, String firstName, String lastName, String email) {
        this.userID = userID;
        this.studentfacultyID = studentfacultyID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public AccountsDTO(int logsID, String studentfacultyID, String role, String firstName, String lastName, String email, String program, String yrlvl, String userTimeIn, String userTimeOut) {
        this.logsID = logsID;
        this.studentfacultyID = studentfacultyID;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.program = program;
        this.yrlvl = yrlvl;
        this.userLogin = userTimeIn;
        this.userLogout = userTimeOut;
    }

    //Student account
    public AccountsDTO(String studentfacultyID, String firstName, String lastName, String email, String program, String yrlvl) {
        this.studentfacultyID = studentfacultyID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.program = program;
        this.yrlvl = yrlvl;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getLogsID() {
        return logsID;
    }

    public void setLogsID(int logsID) {
        this.logsID = logsID;
    }

    public String getStudentfacultyID() {
        return studentfacultyID;
    }

    public void setStudentfacultyID(String studentfacultyID) {
        this.studentfacultyID = studentfacultyID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getYrlvl() {
        return yrlvl;
    }

    public void setYrlvl(String yrlvl) {
        this.yrlvl = yrlvl;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserLogout() {
        return userLogout;
    }

    public void setUserLogout(String userLogout) {
        this.userLogout = userLogout;
    }

    public String getMostLogs() {
        return mostLogs;
    }

    public void setMostLogs(String mostLogs) {
        this.mostLogs = mostLogs;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
