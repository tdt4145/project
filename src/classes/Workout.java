import java.util.ArrayList;
import java.util.HashMap;
import Exercise;
import ExerciseInfo;

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
    this->name = name;
    this->description = description;
    this->date =date;
    this->time = time;
    this->duration = duration;
    this->workoutFeat = workoutFeat;
    this->exercisesInWorkout = new ArrayList<Exercise>();
    this->exercisesInfoInWorkout = new ArrayList<ExerciseInfo>();
  }
  public static void addExerciseAndInfo(Exercise exercise, ExerciseInfo exerciseInfo){
    this->exercisesInWorkout.add(exercise);
    this->exercisesInfoInWorkout.add(exerciseInfo);
  }
}
