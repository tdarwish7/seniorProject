package com.educationwebapplication.educationwebapplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcConnectivity {

    private static final String username = "root";
    private static final String pass = "password";
    private Connection con;
    private Statement statement;
    private List<Resource> resourceList = new ArrayList<>();

    private void select() { };

    public void addUser(String fname, String lname, String email,
                        String userName, String password, String gradeLevel) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);
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
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
/*****************************************************************/

    /**What can be a stored procedure and what cannot be?**/

/*****************************************************************/

    public List<Resource> loadResources() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM Resources");

            while(rs.next()) {
                Resource resource = new Resource();
                resource.setResourceName(rs.getString("CourseName"));
                resource.setResourceType(rs.getString("CourseType"));
                resource.setResourceGradeLevel(rs.getString("GradeLevel"));
                resource.setResourceLink(rs.getString("Link"));
                resourceList.add(resource);
//                String gradeLevel = rs.getString("GradeLevel");
//                String courseName = rs.getString("CourseName");
//                String courseType = rs.getString("CourseType");
//                String link = rs.getString("Link");
//                System.out.println(gradeLevel + ", " + courseName + ", " +courseType +
//                        ", " + link);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return resourceList;
    }


}

