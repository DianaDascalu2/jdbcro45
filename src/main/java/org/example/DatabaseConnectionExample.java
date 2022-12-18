package org.example;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionExample {
    public static void main(String[] args) throws SQLException {
        createTableMarketingCampaign(DatabaseConnection.getConnection());

        Statement statement = null;

        Connection connection;
        connection = DatabaseConnection.getConnection();

        initialiseMarketingCampaign(connection);

    }

    // create a table
    public static void createTableMarketingCampaign(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        statement.execute("create table if not exists marketing_campaign(" +
                "id int primary key auto_increment," +
                "name varchar(200)," +
                "start_date date," +
                "budget double);");
    }

    //insert a row in the table
    public static void initialiseMarketingCampaign(Connection connection) {
        try {
            Statement statement = DatabaseConnection.getConnection().createStatement();

            ResultSet rs = statement.executeQuery("select count(*) from marketing_campaign;");

            if(rs.next()&&rs.getInt(1)==0) {
                statement.execute("insert into marketing_campaign(name, start_date, budget) values " +
                        "('Florina Campaign', '2022-12-01', 12.5);");
                System.out.println("Table has been initialised.");
            }
            else {
                System.out.println("The table was already initialised.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //display all values in a table

    //search in a row by a value
}
