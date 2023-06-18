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
                        System.out.println("Something has gone wrong.");
                    }
                } else {
                    System.out.println(
                            "This is not a valid password. Please enter a stronger password.");
                }
            }
        }
    }

    public static boolean isValidPassword(String password) {
        // Password should consist of one lowercase character, one uppercase character,
        // one number, and must be at least 7 characters long.
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{7,}$";
        return Pattern.matches(regex, password);
    }

    public static void registerUser(String username, String password) throws SQLException {
        // Establish the connection of MySQL database
        String url = "jdbc:mysql://localhost:3306/jdbc_tech?useSSL=false";
        String dbUserName = "root";
        String dbPassword = "25524";
        Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);

        String QUERY = "INSERT INTO users (id, username, password) VALUES (?, ?, ?)";

        // Create a prepared statement
        try (PreparedStatement preStmt = connection.prepareStatement(QUERY)) {
            Random random = new Random();
            int id = random.nextInt(1000);

            // Now enter the users data as many as you want
            preStmt.setInt(1, id);
            preStmt.setNString(2, username);
            preStmt.setNString(3, password);

            int rowsAffected = preStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println(username + " has successfully registered in the database.");
            } else {
                System.out.println(username + " is failed to register in the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    public static void validatePassword(String password) throws Exception {
//        if (password.length() < 8) {
//            throw new Exception("Password must be at least 8 characters long.");
//        }
//        if (!password.matches(".*[a-z].*")) {
//            throw new Exception("Password must contain at least one lowercase letter.");
//        }
//        if (!password.matches(".*[A-Z].*")) {
//            throw new Exception("Password must contain at least one uppercase letter.");
//        }
//        if (!password.matches(".*\\d.*")) {
//            throw new Exception("Password must contain at least one number.");
//        }
//    }

}
