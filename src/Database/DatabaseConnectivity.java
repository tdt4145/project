import java.sql.*;  


class MysqlCon{  

	// Variables for connecting to database
	private static final String DB_DRIVER_PATH = "com.mysql.jdbc.Driver";
	private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/workoutLog?autoReconnect=true&useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "password";

	// Variables for executing queries
	private static Connection con;
	private static ResultSet rs;

	// Function for executing query
	protected static ResultSet executeMyQuery(String query) {

		try{  

			// Prepare your statement 
			Statement stmt=con.createStatement();  
			
			// Execute query and return object
			rs=stmt.executeQuery(query);  

		// print every attribute
		while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  

		// if query fails	
		}catch(
			Exception e){ System.out.println(e);
		} 

		// return result
		return rs;
	}


	// Main
	public static void main(String args[]){  

		try{  
			// Find drivers
			Class.forName(DB_DRIVER_PATH);  

			// Mabye 'con' is only specified locally. Can cause error
			con=DriverManager.getConnection(CONNECTION_STRING,USER,PASS);  
		}catch(Exception e){ System.out.println(e);}  


		// test
		executeMyQuery("SELECT * FROM Exercise");
	}  
}  	