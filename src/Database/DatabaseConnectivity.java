import java.sql.*;  


class MysqlCon{  

	public static void main(String args[]){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/workoutLog","root","password");  
			
			//here 'workoutLog' is database name, 'root' is username and passwod is 'password'  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM Exercise");  
		while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}  
}  	