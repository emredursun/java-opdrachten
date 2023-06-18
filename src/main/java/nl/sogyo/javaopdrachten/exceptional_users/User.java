package nl.sogyo.javaopdrachten.exceptional_users;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a username");
            String username = scanner.nextLine();

            while (true) {
                System.out.println("Enter a password");
                String password = scanner.nextLine();

                if (isValidPassword(password)) {
                    try {
                        registerUser(username, password);
                        System.out.println("Registered user " + username);
                        break;
                    } catch (Exception e) {
                        System.out.println("Something has gone wrong. Error message: " + e.getMessage());
                    }
                } else {
                    System.out.println(
                            "This is not a valid password. Please enter a stronger password.");
                }
            }
        }
    }

    public static boolean isValidPassword(String password) {
        // Password should consist of one lowercase character, one uppercase character, one number, and must be at least 7 characters long.
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{7,}$";
        return Pattern.matches(regex, password);
    }

    public static void registerUser(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/jdbc_tech?useSSL=false";
        String dbUserName = "root";
        String dbPassword = "25524";
        try (Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword)) {
            String QUERY = "INSERT INTO users (id, username, password) VALUES (?, ?, ?)";
            PreparedStatement preStmt = connection.prepareStatement(QUERY);
            int id = new Random().nextInt(1000);
            preStmt.setInt(1, id);
            preStmt.setNString(2, username);
            preStmt.setNString(3, password);
            int rowsInserted = preStmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(username + " has successfully registered in the database.");
            } else {
                System.out.println(username + " is failed to register in the database!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
