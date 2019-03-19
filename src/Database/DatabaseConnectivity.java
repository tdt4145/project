import java.sql.*;  


class DatabaseConnectivity{  

	// Variables for connecting to database
	private static final String DB_DRIVER_PATH = "com.mysql.jdbc.Driver";
	private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/workoutLog?autoReconnect=true&useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "password";

	// Variables for executing queries
	private static Connection con;
	private static ResultSet rs;
	private static Statement stmt;

	// Function for executing
	protected static ResultSet executeGetQuery(String query) {

		try{  

			// Prepare your statement 
			stmt=con.createStatement();  
			
			// Execute query and return object
			rs=stmt.executeQuery(query);  

		// if query fails	
		}catch(SQLException e){ 
			System.out.println(e);
		} 

		// return result
		return rs;
	}

		// Function for executing
	protected static boolean executeSetQuery(String table, String values) {

		try{  

			// Prepare your statement 
			stmt=con.createStatement();  
			stmt.executeUpdate(table + values);

		// if query fails	
		}catch(SQLException e){ 
			System.out.println(e);
			return false;
		} 

		// return result
		return true;
	}

	// Open SQL connection
	private static void openConnection() {
		try{  
			// Find drivers
			Class.forName(DB_DRIVER_PATH);  

			// Mabye 'con' is only specified locally. Can cause error
			con=DriverManager.getConnection(CONNECTION_STRING,USER,PASS);  

		}catch(Exception e){
		 System.out.println(e);
		}  		
	}


	// Close SQL connection
	private static void closeConnection(){

		try{
			// close connection to database
			con.close(); 

		}catch(Exception e){
		 System.out.println(e);
		}
	}



	// Main
	public static void main(String args[]){
		// test
		try{
			openConnection();
			//ResultSet rs = executeMyQuery("SELECT * FROM Exercise");
			//int rs = executeUpdate("INSERT INTO Exercise VALUES(1,'Petter', 'har bursdag);");
					// Prepare your statement 
			rs = executeGetQuery("SELECT * FROM Exercise");
			
			while(rs.next()){  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
			}		

			boolean completed = executeSetQuery("INSERT INTO Exercise ", "VALUES (18, 'Petter', 'har bursdag')");
			System.out.println(comleted);

			rs = executeGetQuery("SELECT * FROM Exercise");			
			while(rs.next()){  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
			}		

			closeConnection();

		}catch(Exception e){
			System.out.println(e);
		} 
	}  
}  		