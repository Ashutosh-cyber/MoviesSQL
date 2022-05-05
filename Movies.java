import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Movies {
    static final String DB_URL = "jdbc:mysql://localhost:3306/cashew";
    static final String USER = "root";
    static final String PASS = "Ashutosh12@";

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE DATABASE STUDENTS";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try(
        ){
            String sql = "CREATE TABLE MOVIES " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " director VARCHAR(255), " +
                    " year INTEGER, " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try(
        ){
            // Execute a query
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO Movies VALUES (1, 'Avatar', 'James Cameron', 2009)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Movies VALUES (2, 'Iron Man', 'Jon Favreau', 2008)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Movies VALUES (3, 'Inception', 'Christopher Nolan', 2010)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Movies VALUES(4, 'Dune', 'Denis Villeneuve', 2021)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        static final String QUERY = "SELECT id, name, director, year FROM Movies";
        try(
            ResultSet rs = stmt.executeQuery(QUERY);
        ) {
            while(rs.next()){
                //Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Name: " + rs.getInt("age"));
                System.out.print(", Director: " + rs.getString("first"));
                System.out.println(", Year: " + rs.getString("last"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}