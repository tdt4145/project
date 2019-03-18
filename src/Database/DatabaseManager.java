package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseManager {
	private static final String DB_DRIVER_PATH = "com.mysql.cj.jdbc.Driver", 
			DB_NAME="database_name", DB_USERNAME = "username", DB_PASSWORD = "password", 
			CONNECTION_STRING = "jdbc:mysql://mysql.stud.ntnu.no/" + DB_NAME + "?serverTimezone=UTC";
	
	private static Connection connection;
	
	
	static { 
		openConnection();
	}
	
	private static void openConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(CONNECTION_STRING, DB_USERNAME, DB_PASSWORD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println();
			}
	
	}
	
	private static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	private static ResultSet getExercises() {
		String queryString = "FROM Excersice SELECT *";
		ResultSet resultSet = null;
		resultSet = executeQuery(queryString);
		return resultSet;
	}
	
	
	private static ResultSet executeQuery(String queryString) {
		ResultSet resultSet = null;
		try {

			Statement statement = connection.createStatement();
			statement.executeQuery(queryString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// Her er det kanskje aktuelt å prøve å åpne connection igjen.
			e.printStackTrace();
		}
		
		return resultSet;
		
		
	}
	
	public static void main(String[] args) {
		
	}
}
