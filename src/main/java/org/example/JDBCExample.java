package org.example;

import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flower_shop", "root", "1234");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select * from product where id = 1");
            rs.next();
            System.out.println(rs.getString(2) + rs.getString(4));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}