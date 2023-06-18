package nl.sogyo.javaopdrachten.exceptional_users;

import java.sql.*;

public class ReadDB {
    private static final String QUERY = "select * from users";
    public static void main(String[] args) {
        // Establish the connection of MySQL database
        String url = "jdbc:mysql://localhost:3306/jdbc_tech?useSSL=false";
        String userName = "root";
        String userPassword = "25524";

        try (Connection conn = DriverManager.getConnection(url, userName, userPassword)) {

            // 2. Prepare the SQL statement using that above connection
            Statement stmt = conn.createStatement();

            // 3. Execute the query. There are two methods for executing the query. Execute(), ExecuteQuery()
            ResultSet rs = stmt.executeQuery(QUERY);

            // 4. Process the result and execute the statement
            while (rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");

                // Finally printout the result
                System.out.println(id + username + password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
