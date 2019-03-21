package classes;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Workout {
  String date;
  String time;
  String duration;
  String workoutFeat; //Number between 0 and 9
  String workoutForm; //Number between 0 and 9
  String note;
  List<ExerciseInfo> exerciseInfoInWorkout;

  public Workout(String date, String time, String duration, String workoutFeat, String workoutForm, String note){
    this.date = date;
    this.time = time;
    this.duration = duration;
    this.workoutFeat = workoutFeat;
    this.workoutForm = workoutForm;
    this.note = note;
    this.exerciseInfoInWorkout = new ArrayList<ExerciseInfo>();
  }
  public void addExerciseAndInfo(ArrayList<ExerciseInfo> exerciseInfo){
    this.exerciseInfoInWorkout.addAll(exerciseInfo);
  }
}
