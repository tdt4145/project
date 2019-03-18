import java.sql.*;  


class MysqlCon{  

	private static final String DB_DRIVER_PATH = "com.mysql.jdbc.Driver";
	private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/workoutLog?autoReconnect=true&useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "password";


	protected static ResultSet executeMyQuery(String query) {

		try{  
			 
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(query);  

		while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){ System.out.println(e);} 

		Return ResultSet;
	}


	// Main
	public static void main(String args[]){  

		try{  
			// Find drivers
			Class.forName(DB_DRIVER_PATH);  

			//here 'workoutLog' is database name, 'root' is username and passwod is 'password' 
			// Mabye 'con' is only specified locally. Can cause error
			Connection con=DriverManager.getConnection(CONNECTION_STRING,USER,PASS);  
		}catch(Exception e){ System.out.println(e);}  


		executeQuery("SELECT * FROM Exercise");
	}  
}  	