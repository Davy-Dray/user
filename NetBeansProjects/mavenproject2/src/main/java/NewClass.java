
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author user
 */
public class NewClass {

    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=bikestores;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String password = "reallyStrongPwd123";

        Connection conn = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
            String selectQuery = "SELECT * FROM production.brands"; 
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("brand_id");
                String name = resultSet.getString("brand_name");

                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}
