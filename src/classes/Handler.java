import Database.DatabaseConnectivity;
import java.sql.*;

public class Handler {

  public static boolean showAllExercises(){
    String queryString = "SELECT * FROM Exercises";
    System.out.println = "----- LIST OF ALL EXERCISES -----";
    ResultSet rs = executeMyQuery(queryString);
    while(rs.next()) {
        system.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
    }
    System.out.println = "----- END OF LIST -----";
    return true;
  }

  public static boolean showAllEquipment(){
    String queryString = "SELECT * FROM Equipment";
    System.out.println = "----- LIST OF ALL EQUIPMENT -----";
    String rs = executeMyQuery(queryString);
    while(rs.next()) {
        system.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
    }
    System.out.println = "----- END OF LIST -----";
    return true;
  }

  public static boolean showAllGroups(){
    String queryString = "SELECT * FROM ExerciseGroup";
    System.out.println = "----- LIST OF ALL EXERCISE GROUPS -----";
    String sqlReturn = executeMyQuery(queryString);
    while(rs.next()) {
        system.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
    }
    System.out.println = "----- END OF LIST -----";
    return true;
  }

  public static boolean registerEquipment(String name, String description){
    String queryString = "INSERT INTO Equipment VALUES (" + name + ", " + description + ")";
    ResultSet = executeMyQuery(queryString);
    return true;
  }

  public static boolean registerExercise(String name, String description, int equipmentID){
    String queryString = "INSERT INTO Exercise VALUES (" + name + ", " + description + ")";

    //return ExerciseID
    String sqlReturn = executeQuery(queryString);

    return true;
  }

  public static boolean registerWorkout(String name, String description, int exerciseFeat, int weight,
    int numberOfSets, ArrayList<Exercise> exerciseInWorkout, ArrayList<ExerciseInfo> exerciseInfoInWorkout) {
    String queryString = "INSERT INTO workout VALUES (" + name + ", " + description + ")";
    String sqlReturn = executeQuery(queryString);


    ArrayList<String> exercises = new ArrayList<String>();
    ArrayList<ExerciseInfo> exerciseInfo = new ArrayList<exerciseInfo>();
  }






  public boolean getExerciseInGroup(String exerciseGroup) {
    String queryString  = "SELECT * FROM .....";
    String sqlReturn = executeQuery(queryString);
    if (sqlReturn.isEqual("") {
      return false;
    }
    else {
      //Split this into readable return values before printing
      System.out.println(sqlReturn);
      return true;
    }
  }
}
