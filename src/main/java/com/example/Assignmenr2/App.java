package com.example.Assignmenr2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "myDataBase", "Test");
        		Statement stmt = conn.createStatement()){
        	stmt.execute("CREATE TABLE IF NOT EXISTS sample_data (id INT AUTO_INCREMENT PRIMARY KEY, data VARCHAR(225))");
        	stmt.execute("INSERT INTO sample_data (data) VALUES ('Aparna')");
        	ResultSet rs = stmt.executeQuery("SELECT * FROM sample_data");
        	while(rs.next()) {
        		System.out.println("Data from Database: " +rs.getString("data"));
        	}
        }catch (SQLException e) {
        	e.printStackTrace();
        	} 
    }
}
