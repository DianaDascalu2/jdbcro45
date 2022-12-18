package org.example;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

    public final static String DATABASE_URL =   "jdbc:mysql://localhost:3306/flower_shop" ;
    public final static String DATABASE_USER = "root";
    public final static String DATABASE_PASSWORD = "1234";
    private static Connection connection;

    public static Connection getConnection() {
        if(connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl(DATABASE_URL);
            dataSource.setUser(DATABASE_USER);
            dataSource.setPassword(DATABASE_PASSWORD);

            try {
                connection = dataSource.getConnection();
                return connection;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }}
            else {
                return connection;
            }
        }
    }
