package classes;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Workout {
  String name;
  String description;
  String date;
  String time;
  String duration;
  int workoutFeat;
  List<ExerciseInfo> exerciseInfoInWorkout;

  public Workout(String name, String description, String date, String time, String duration, int workoutFeat){
    this.name = name;
    this.description = description;
    this.date =date;
    this.time = time;
    this.duration = duration;
    this.workoutFeat = workoutFeat;
    this.exerciseInfoInWorkout = new ArrayList<ExerciseInfo>();
  }
  public void addExerciseAndInfo(ArrayList<ExerciseInfo> exerciseInfo){
    this.exerciseInfoInWorkout.addAll(exerciseInfo);
  }
}
