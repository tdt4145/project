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
	    String queryString = "SELECT * FROM Workout;";
	    System.out.println("----- LIST OF ALL WORKOUTS -----");
	    ResultSet rs = DatabaseConnectivity.executeGetQuery(queryString);
	    try {
			while(rs.next()) {
			    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+ "  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+ "  "+rs.getString(7));
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

  public static boolean registerEquipment(Equipment equipment){
    String queryString = "INSERT INTO Equipment (name, description) VALUES ('" + equipment.name + "', '" + equipment.description + "');";
    boolean rs = DatabaseConnectivity.executeSetQuery(queryString);
    return rs;
  }

  public static boolean registerExercise(Exercise exercise, String equipmentID){
    String sqlString1 = "INSERT INTO Exercise (name, description) VALUES ('" + exercise.name + "', '" + exercise.description + "');";
    boolean isOK = DatabaseConnectivity.executeSetQuery(sqlString1);
    
    if (equipmentID.equals("-1")){
    	return isOK;
    } else {
	    String sqlString2  = "SELECT exerciseID FROM Exercise ORDER BY exerciseID DESC LIMIT 1;";
	    ResultSet rs = DatabaseConnectivity.executeGetQuery(sqlString2);
	    int exerciseID = 0;
	    int equipmentID_int = Integer.parseInt(equipmentID);
		try {
			// must have the while loop
			while(rs.next()){  
				exerciseID = rs.getInt(1); 
			}		
			//exerciseID = rs.getInt(1);
			String exerciseID_string = Integer.toString(exerciseID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String sqlString3 = "INSERT INTO ExerciseOnEquipment VALUES (" + equipmentID + ", " +  exerciseID + ");";
	    isOK = DatabaseConnectivity.executeSetQuery(sqlString3);
	}
    return isOK;
  }

  public static boolean registerWorkout(Workout workout) {
    String queryString = "INSERT INTO Workout" +
    		"(workoutDate, workoutTime, duration, personalForm, personalFeat, note)" +
    		" VALUES ('" + workout.date+ "', '" + workout.time + "', '" + workout.duration + 
    		"', '" + workout.workoutForm + "', '" + workout.workoutFeat + "', '" + workout.note + "')";
    boolean isOK = DatabaseConnectivity.executeSetQuery(queryString);
    
    
    return isOK;
  }
  
  public static boolean registerExerciseGroup(String name, String description) throws SQLException{
	    String sqlString = "INSERT INTO ExerciseGroup (name, description) VALUES ('" + name + "', '" + description + "');";
	    boolean isOK = DatabaseConnectivity.executeSetQuery(sqlString);
	    
	    /*
	    String sqlString1 = "SELECT groupID FROM ExerciseGroup ORDER BY exercise DESC LIMIT 1";
	    ResultSet rs = DatabaseConnectivity.executeGetQuery(sqlString1);
	    
	    for (Exercise exercise : exercises){
	    	String sqlString3 = "INSERT INTO ExerciseInGroup VALUES (" + exercise.exerciseID + ", " + rs.getInt(1);
	    	isOK = DatabaseConnectivity.executeSetQuery(sqlString);
	    }*/
	    return isOK;
	  }
  
  public static boolean addExerciseToGroup(String groupID, String exerciseID){
	  String sqlString = "INSERT INTO ExerciseInGroup (exerciseGroupID, exerciseID) VALUES (" + groupID + ", " + exerciseID + ");";
	  System.out.println(sqlString);
	  boolean isOK = DatabaseConnectivity.executeSetQuery(sqlString);
	  return isOK;
  }
  
  public static boolean getNLastWorkouts(String userString) {
	  String sqlString = "SELECT Workout.workoutID, Workout.note FROM Workout LIMIT 0," + userString + ";";
	  ResultSet rs = DatabaseConnectivity.executeGetQuery(sqlString);
	  System.out.println("---- LIST OF LAST WORKOUTS ----");
	  try {
		  while(rs.next()){
			  System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
		  } 
	  }catch(SQLException e){
		  e.printStackTrace();
		  return false;
	  }
	  return true;
  }

  public static boolean getExercisesInGroup(String exerciseGroup) {
    String queryString  = "SELECT Exercise.exerciseID, Exercise.name, Exercise.description FROM Exercise JOIN ExerciseInGroup NATURAL JOIN ExerciseGroup WHERE ExerciseGroup.exerciseGroupID =" +
					exerciseGroup + ";";
    ResultSet rs = DatabaseConnectivity.executeGetQuery(queryString);


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
  
  public static boolean showMostFrequentExercise(){
	  String sqlString = "SELECT ExerciseID, count(*) as count FROM ExerciseInWorkout GROUP BY ExerciseID ORDER BY count DESC LIMIT 1;";
	  ResultSet rs = DatabaseConnectivity.executeGetQuery(sqlString);
	  System.out.println("The most frequent exercise completed:");
	    try {
			while(rs.next()) {
			    System.out.println(rs.getInt(1)+"  "+rs.getInt(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	  return true;
  }
  public static boolean getResultsInInterval(String exerciseID, String firstDate, String lastDate){
	 String sqlString = "SELECT * FROM ExerciseInWorkout NATURAL JOIN Workout WHERE ExerciseInWorkout.exerciseID=" + exerciseID + " AND " +
	 		"Workout.workoutDate > DATE('" + firstDate +"')" +
	 		"AND Workout.workoutDate < DATE('"+ lastDate +"');";
	  ResultSet rs = DatabaseConnectivity.executeGetQuery(sqlString);
	  System.out.println("The results of the exercise in the given time interval:");
	    try {
			while(rs.next()) {
			    System.out.println(rs.getInt(1)+"  "+rs.getInt(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	 return true;
  }
  
}
