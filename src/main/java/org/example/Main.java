package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Statement statement = DatabaseConnection.getConnection().createStatement();

            int rowCount = statement.executeUpdate("insert into product (name, price, quantity, type) values ('Ivy', 12.3, 20, 'flower')," +
                                                                                                                "('Bonsai', 13.35, 30, 'Potted plant')");
            System.out.println("Row count "+rowCount);

            ResultSet productSet = statement.executeQuery("SELECT * from product");

            while(productSet.next()) {
                System.out.println("Product: "+productSet.getString(2));
                System.out.println(" with price: "+productSet.getDouble(3));
                System.out.println(" and quantity: "+productSet.getInt(4));
            }

            ResultSet mostExpensiveProduct = statement.executeQuery("select * from product where price = (select max(price)from product)");

            mostExpensiveProduct.next();

            System.out.println("Most expensive product is: "+mostExpensiveProduct.getString(2)+" with a price of "+mostExpensiveProduct.getDouble(3));

            statement.executeUpdate("insert into product (name, price, quantity, type) values ('Ivy',   12.3, 20, 'Flower')");

            ResultSet allFlowers = statement.executeQuery("select * from product where product.quantity < 10 and product.price < 5.00");

            System.out.println("All flowers less than 10 quantity and less than 5.00 are : ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
