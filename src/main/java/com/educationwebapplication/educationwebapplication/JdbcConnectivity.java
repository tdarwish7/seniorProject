package com.educationwebapplication.educationwebapplication;

import java.sql.*;

public class JdbcConnectivity {

    private static final String username = "root";
    private static final String pass = "password";
    private Connection con;
    private Statement statement;

    private void select() { };

    public void addUser(String fname, String lname, String email,
                        String userName, String password, String gradeLevel) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationWebsite", username, pass);
            statement = con.createStatement();
            String sql = "INSERT INTO Users" +
                    "(FirstName, LastName, EmailAddress, UserName, Password, GradeLevel) VALUES( ?, ?, ?, ?, ?, ? )";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, fname);
            preparedStatement.setString(2, lname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, userName);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, gradeLevel);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

