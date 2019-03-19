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
  List<Exercise> exercisesInWorkout;
  List<ExerciseInfo> exerciseInfoInWorkout;

  public Workout(String name, String description, String date, String time, String duration, int workoutFeat){
    this.name = name;
    this.description = description;
    this.date =date;
    this.ime = time;
    this.duration = duration;
    this.workoutFeat = workoutFeat;
    this.exercisesInWorkout = new ArrayList<Exercise>();
    this.exercisesInfoInWorkout = new ArrayList<ExerciseInfo>();
  }
  public static void addExerciseAndInfo(Exercise exercise, ExerciseInfo exerciseInfo){
    this.exercisesInWorkout.add(exercise);
    this.exercisesInfoInWorkout.add(exerciseInfo);
  }
}
