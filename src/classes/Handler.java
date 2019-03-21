package classes;
import Database.DatabaseConnectivity;
import java.sql.*;
import java.util.ArrayList;

public class Handler {

  public static boolean showAllExercises(){
    String queryString = "SELECT * FROM Exercise;";
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
  
  public static boolean showAllWorkouts(){
	    String queryString = "SELECT * FROM Workouts;";
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
  
  public static boolean showExercisesInGroup(String groupID){
	  String sqlString = "SELECT name FROM Exercises JOIN ExerciseInGroup WHERE groupID = " + groupID;
	    System.out.println("----- LIST OF ALL EXERCISES IN THIS GROUP-----");
	    ResultSet rs = DatabaseConnectivity.executeGetQuery(sqlString);
	    try {
			while(rs.next()) {
			    System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("----- END OF LIST -----");
	  return true;
  }
  
  public static boolean showMostFrequentExercise(){
	  String sqlString = "SELECT name FROM Workout";
	  //TODO
	  return true;
  }

  public static boolean registerEquipment(Equipment equipment){
    String queryString = "INSERT INTO Equipment VALUES (" + equipment.name + ", " + equipment.description + ");";
    boolean rs = DatabaseConnectivity.executeSetQuery(queryString);
    return rs;
  }

  public static boolean registerExercise(Exercise exercise, int equipmentID){
    String sqlString1 = "INSERT INTO Exercise VALUES (" + exercise.name + ", " + exercise.description + ");";
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

  public static boolean registerWorkout(Workout workout) {
    String queryString = "INSERT INTO workout VALUES (" + workout.name + ", " + workout.description + ")";
    boolean rs = DatabaseConnectivity.executeSetQuery(queryString);
    
    
    return true;
  }
  public static boolean registerExerciseGroup(String name, String description, ArrayList<Exercise> exercises) throws SQLException{
	    String sqlString = "INSERT INTO ExerciseGroup VALUES (" + name + ", " + description + ");";
	    boolean isOK = DatabaseConnectivity.executeSetQuery(sqlString);
	    
	    String sqlString1 = "SELECT groupID FROM ExerciseGroup ORDER BY exercise DESC LIMIT 1";
	    ResultSet rs = DatabaseConnectivity.executeGetQuery(sqlString1);
	    
	    for (Exercise exercise : exercises){
	    	String sqlString3 = "INSERT INTO ExerciseInGroup VALUES (" + exercise.exerciseID + ", " + rs.getInt(1);
	    	isOK = DatabaseConnectivity.executeSetQuery(sqlString);
	    }
	    return isOK;
	  }

  public boolean getExerciseInGroup(String exerciseGroup) {
    String queryString  = "SELECT * FROM .....";
    ResultSet rs = DatabaseConnectivity.executeGetQuery(queryString);
    try {
		if (rs.getString(2).equals("")) {
		  return false;
		}
		else {
		    try {
				while(rs.next()) {
				    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		  return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
  }
}
