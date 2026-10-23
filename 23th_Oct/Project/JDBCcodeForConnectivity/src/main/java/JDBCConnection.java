import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
    public static void main(String[] ars){

        // MySQL database details
        String url = "jdbc:mysql://localhost:3306/javaPMIS";
        String username = "root";
        String password = "Ajay@1234";


        String createTable = "CREATE TABLE IF NOT EXISTS students (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(100) NOT NULL, " +
                "course VARCHAR(100) NOT NULL" +
                ")";

        String insertSql =
                "INSERT INTO students (name, course) VALUES (?, ?)";

        String selectSql = "SELECT id, name, course FROM students";



        try(Connection con = DriverManager.getConnection(url, username, password);){

            System.out.println("Connection successfull!");
            System.out.println("Database name: "+ con.getCatalog());

        }catch (SQLException e){

            System.out.println("Connection failed!");
            e.printStackTrace();

        }
    }

}
