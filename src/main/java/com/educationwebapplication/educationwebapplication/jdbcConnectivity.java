package com.educationwebapplication.educationwebapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcConnectivity {

    private static final String username = "admin";
    private static final String password = "password";

    jdbcConnectivity() {
        try{
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/educationWebsite", username, password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from login");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }


}

