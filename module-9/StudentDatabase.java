/*
    Xavier Grunitzky
    5/10/26
    Module 9.2 Assignment
    This program uses the DriverManager class from JDBC to establish a connection between the Java application and a MySQL database.
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class StudentDatabase {
    public static void main(String[] args) {
        // JDBC URL to connect to MySQL database
        // localhost = your local machine
        String url = "jdbc:mysql://localhost:3306/databasedb?useSSL=false&serverTimezone=UTC";
        String user = "student1";
        String password = "pass";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println("SUCCESS: Connected to databasedb as student1!");
            conn.close();

        } catch (Exception e) {
            System.out.println("FAILED: Connection not successful.");
            e.printStackTrace();
        }
    }
}