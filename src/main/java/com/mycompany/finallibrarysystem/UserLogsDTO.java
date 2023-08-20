/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finallibrarysystem;

/**
 *
 * @author araos
 */
public class UserLogsDTO {

    private int userID;
    private int logsID;
    private String logsDuration;
    private String mostLogs;
    private String studentfacultyID;
    private String status;
    private String role;
    private String firstName;
    private String lastName;
    private String fullname;
    private String program;
    private String yrlvl;
    private String reason;
    private String loginTime;
    private String logoutTime;
    private String email;

    public UserLogsDTO(String studentfacultyID, String firstName, String lastName, String email) {
        this.studentfacultyID = studentfacultyID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    public UserLogsDTO(String role, String fullname, String program, String yrlvl, String reason, String loginTime, String logoutTime) {
        this.role = role;
        this.fullname = fullname;
        this.program = program;
        this.yrlvl = yrlvl;
        this.reason = reason;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
    }

    public UserLogsDTO(String fullname, String program, String yrlvl) {
        this.fullname = fullname;
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

    public String getLogsDuration() {
        return logsDuration;
    }

    public void setLogsDuration(String logsDuration) {
        this.logsDuration = logsDuration;
    }

    public String getMostLogs() {
        return mostLogs;
    }

    public void setMostLogs(String mostLogs) {
        this.mostLogs = mostLogs;
    }

    public String getStudentfacultyID() {
        return studentfacultyID;
    }

    public void setStudentfacultyID(String studentfacultyID) {
        this.studentfacultyID = studentfacultyID;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    


}
