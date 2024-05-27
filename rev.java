package com.begining;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class rev {
    public static void main(String[] args) throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student", "root", "shekhar1234@");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
