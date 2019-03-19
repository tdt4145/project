package classes;
import Database.DatabaseConnectivity;
import java.sql.*;
import java.util.ArrayList;

public class Handler {

  public static boolean showAllExercises(){
    String queryString = "SELECT * FROM Exercise;s";
    System.out.println("----- LIST OF ALL EXERCISES -----");
    ResultSet rs = DatabaseConnectivity.executeGetQuery(queryString);
    try {
		while(rs.next()) {
		    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println("----- END OF LIST -----");
    return true;
  }

  public static boolean showAllEquipment(){
    String queryString = "SELECT * FROM Equipment;";
    System.out.println("----- LIST OF ALL EQUIPMENT -----");
    ResultSet rs = DatabaseConnectivity.executeGetQuery(queryString);
    try {
		while(rs.next()) {
		    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println("----- END OF LIST -----");
    return true;
  }

  public static boolean showAllGroups(){
    String queryString = "SELECT * FROM ExerciseGroup;";
    System.out.println("----- LIST OF ALL EXERCISE GROUPS -----");
    ResultSet rs = DatabaseConnectivity.executeGetQuery(queryString);
    try {
		while(rs.next()) {
		    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println("----- END OF LIST -----");
    return true;
  }

  public static boolean registerEquipment(String name, String description){
    String queryString = "INSERT INTO Equipment VALUES (" + name + ", " + description + ");";
    boolean rs = DatabaseConnectivity.executeSetQuery(queryString);
    return true;
  }

  public static boolean registerExercise(String name, String description, int equipmentID){
    String sqlString1 = "INSERT INTO Exercise VALUES (" + name + ", " + description + ");";
    boolean isOK = DatabaseConnectivity.executeSetQuery(sqlString1);
    
    String sqlString2  = "SELECT exerciseID FROM Exercise ORDER BY exerciseID DESC LIMIT 1;";
    ResultSet rs = DatabaseConnectivity.executeGetQuery(sqlString2);
    int exerciseID = 0;
	try {
		exerciseID = rs.getInt(1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    String sqlString3 = "INSERT INTO ExerciseOnEquipment VALUES (" + exerciseID + ", " + Integer.toString(equipmentID) + ");";
    isOK = DatabaseConnectivity.executeSetQuery(sqlString3);
    return isOK;
  }

  /*public static boolean registerWorkout(String name, String description, int exerciseFeat, int weight,
    int numberOfSets, ArrayList<Exercise> exerciseInWorkout, ArrayList<ExerciseInfo> exerciseInfoInWorkout) {
    String queryString = "INSERT INTO workout VALUES (" + name + ", " + description + ")";
    boolean sqlReturn = DatabaseConnectivity.executeSetQuery(queryString);

    ArrayList<String> exercises = new ArrayList<String>();
    ArrayList<ExerciseInfo> exerciseInfo = new ArrayList<exerciseInfo>();
  }

  public boolean getExerciseInGroup(String exerciseGroup) {
    String queryString  = "SELECT * FROM .....";
    String sqlReturn = DatabaseConnectivity.executeQuery(queryString);
    if (sqlReturn.Equal("")) {
      return false;
    }
    else {
      //Split this into readable return values before printing
      System.out.println(sqlReturn);
      return true;
    }
  }*/
}
