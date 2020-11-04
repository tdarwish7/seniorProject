package com.educationwebapplication.educationwebapplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcConnectivity {

    private static final String username = "eduappuser";
    private static final String pass = "test2025";
    private Connection con;
    private Statement statement;
    private List<Resource> resourceList = new ArrayList<>();

    private void select() { };

    public void addStudent(String fname, String lname, String email,
                        String userName, String password, String gradeLevel) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);

            String sql = "INSERT INTO students" +
                    "(FirstName, LastName, UserName, EmailAddress, PasswordSalt , PasswordHash, StudentGradeLevel) VALUES( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, fname);
            preparedStatement.setString(2, lname);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, "test");
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, gradeLevel);
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

    public void addTeacher(String fname, String lname, String email,
                           String userName, String password, String subject) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);

            String sql = "INSERT INTO teachers" +
                    "(FirstName, LastName, UserName, EmailAddress, PasswordSalt , PasswordHash, Subject) VALUES( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, fname);
            preparedStatement.setString(2, lname);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, "test");
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, subject);
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
// HEAD
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




    public boolean login(String userName, String password) {
        ResultSet rs;
        String dbpassword="";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);
            String sql = "select passwordHash from students where UserName='"+userName+"'";
            statement = con.createStatement();
            rs = statement.executeQuery(sql);
            while(rs.next()) {
                dbpassword = rs.getString("passwordHash");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                con.close();
                if(dbpassword.equals(password) )
                    return true;
                else
                    return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
// login
}

