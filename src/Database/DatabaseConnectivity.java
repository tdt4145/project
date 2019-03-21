package Database;

import java.sql.*;  


public class DatabaseConnectivity{  

	// Variables for connecting to database
	private static final String DB_DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/workoutlog?autoReconnect=true&useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "password";

	// Variables for executing queries
	private static Connection con;
	private static ResultSet rs;
	private static boolean rs1;
	private static PreparedStatement preppedStatement;
	
	/*
	static {
		openConnection();
	}*/
	
	// Function for executing
	public static ResultSet executeGetQuery(String query) {
		preppedStatement = null;
		rs = null;
		try{  
			preppedStatement = con.prepareStatement(query);
			// Prepare your statement 
			//stmt=con.createStatement();  
			
			// Execute query and return object
			//rs=stmt.executeQuery(query);  
			rs = preppedStatement.executeQuery();
		// if query fails	
		}catch(SQLException e){ 
			System.out.println(e);
		} 

		// return result
		return rs;
	}

		// Function for executing
	public static boolean executeSetQuery(String queryString) {
		preppedStatement = null;
		rs1 = false;
		try{  
			// Prepare your statement 
			//stmt=con.createStatement();  
			//stmt.executeUpdate(queryString);
			preppedStatement = con.prepareStatement(queryString);
			rs1 = preppedStatement.execute();
		// if query fails	
		}catch(SQLException e){ 
			System.out.println(e);
			return false;
		} 

		// return result
		return true;
	}

	// Open SQL connection
	public static void openConnection() {
		con = null;
		try{  
			// Find drivers
			Class.forName(DB_DRIVER_PATH);  

			// Mabye 'con' is only specified locally. Can cause error
			con=DriverManager.getConnection(CONNECTION_STRING,USER,PASS);  

		}catch(Exception e){
		 System.out.println("Can't open connection");
		}  		
	}


	// Close SQL connection
	public static void closeConnection(){

		try{
			// close connection to database
			con.close(); 

		}catch(Exception e){
		 System.out.println(e);
		}
	}
}  		