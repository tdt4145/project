package Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Database.ControllerState;
import classes.*;

//En klasse som inneholder all logikk rundt brukeropplevelsen
public class MainController {
	public ControllerState controllerState;
	public Workout newWorkout;
	public Equipment newEquipment;
	public ArrayList<ExerciseInfo> exerciseInfos;
	public Exercise newExercise = new Exercise("name", "desc");
	
	
	public MainController() {
		this.controllerState = ControllerState.INIT;
		this.newWorkout = new Workout("date", "time", "duration", "5", "5", "note");
		this.exerciseInfos = new ArrayList<ExerciseInfo>();
	}
	
	//Takes input and responds to the user and changes the state accordingly 
	public void takeInput(String userString) {
		String[] userStringSplit;
		if(userString == null) {
			return;
		}
		if(userString == "dev") {
			System.out.println("State: " + this.controllerState);
		}
		
		switch (this.controllerState) {
		//State in which we descide wich mode we will enter and print the neccessary instructions
		case INIT:
			switch (userString) {
			case "1":
				System.out.println("Please input the exercise data in the following format \"name, description, equipment ID\", if an equpment is not needed set the last parameter to -1)");
				this.controllerState = ControllerState.INSERT_EXERCISE;
				return;
			case "2":
				System.out.println("Please input the Workout data in the following format (workoutDate, workoutTime, duration, workoutForm, workoutFeat, note)");
				this.controllerState = ControllerState.CREATE_WORKOUT;
				return;
			case "3":
				System.out.println("Please input the new equipment data in the following format (name, desc)");
				this.controllerState = ControllerState.INSERT_EQUIPMENT;
				return;
			case "4":
				System.out.println("Please input the new exercise group in the following format: (name, description)");
				this.controllerState = ControllerState.CREATE_EXERCISE_GROUP;
				return;
			case "5":
				Handler.showAllGroups();
				Handler.showAllExercises();
				System.out.println("Pick a group and exercise from the lists above and input the group data in the following format: (groupID, exerciseID)");
				this.controllerState = ControllerState.INSERT_EXERCISE_INTO_GROUP;
				return;
			case "6":
				Handler.showAllExercises();
				return;
			case "7":
				Handler.showAllWorkouts();
				return;
			case "8":
				Handler.showAllEquipment();
				return;
			case "9":
				Handler.showAllGroups();
				return;
			case "10":
				System.out.println("Please input the group for which you whish to se the exercises:");
				//this.controllerState = ControllerState.INSERT_GROUP_NUMBER_FOR_VIEWING_EXERCISES;
				return;
			case "11":
				System.out.println("Please input the amount of the last completed workouts you whish to see:");
				//this.controllerState = ControllerState.INSERT_NUMBER_FOR_VIEWING_LATEST_WORKOUTS;
				return;
			case "12":
				//TODO: Discuss with Petter the desired input format
				System.out.println("Please input the the exercise ID and the time interval in the following format: \"ID\",\"DD.MM.YYYY\",\\\"DD.MM.YYYY\\\"");
				//this.controllerState = ControllerState.INSERT_NUMBER_FOR_VIEWING_LATEST_WORKOUTS;
				return;
			case "13":
				Handler.showMostFrequentExercise();
				return;
			default:
				break;
			}
			break;
		case INSERT_EXERCISE:
			try {
				// Will treat the user input as a touple that describes an exercise WITH out WITHOUT an equipment
				userStringSplit = userString.split(", ");
				this.newExercise = new Exercise(userStringSplit[0], userStringSplit[1]);
				Handler.registerExercise(this.newExercise, userStringSplit[2]);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			break;
		case INSERT_EQUIPMENT:
			try {
				userStringSplit = userString.split(", ");
				System.out.println(userStringSplit[1]);
				this.newEquipment = new Equipment(userStringSplit[0], userStringSplit[1]);
				boolean k = Handler.registerEquipment(this.newEquipment);
			} catch (Exception e) {
				System.out.println("Error during registration of equipment. Try again!" + e.toString());
			}
			break;
		case CREATE_WORKOUT:
			try {
				userStringSplit = userString.split(", ");
				this.newWorkout = new Workout(userStringSplit[0], userStringSplit[1], userStringSplit[2], userStringSplit[3], userStringSplit[4], userStringSplit[5]);
				Handler.showAllExercises();
				this.controllerState = ControllerState.INSERT_EXERCISE_INTO_WORKOUT;
				System.out.println("Registrated the Workout successfully, please insert the exercise ID, weight, excersiceFeat, numberOfSets. Write \"done\" when done.");
			} catch (Exception e) {
				System.out.println("Error during registration. Try again!" + e.toString());
			}
			
			break;
		case CREATE_EXERCISE_GROUP:
			try {
				userStringSplit = userString.split(", ");
				Handler.registerExerciseGroup(userStringSplit[0], userStringSplit[1]);
			} catch (Exception e) {
				System.out.println("Error during registration of equipment. Try again!" + e.toString());
			}
			break;
		case INSERT_EXERCISE_INTO_WORKOUT:
			if(userString.equals("done")) {
				System.out.println("try");
				//Trigger method in Handler to save the Workout object with the list of Exercises
				this.newWorkout.addExerciseAndInfo(this.exerciseInfos);
				Handler.registerWorkout(this.newWorkout);
				this.controllerState = ControllerState.INIT;
			}
			try {
				// Will treat the input as a exercise ID and info.
				userStringSplit = userString.split(", ");
				this.exerciseInfos.add(new ExerciseInfo(userStringSplit[0], userStringSplit[1], userStringSplit[2]));
			} catch (Exception e) {
				System.out.println("Error during regestration of exercise: " + e.toString());
			}
			break;
		case INSERT_EXERCISE_INTO_GROUP:
			try {
				userStringSplit = userString.split(", ");
				Handler.addExerciseToGroup(userStringSplit[0], userStringSplit[1]);
			} catch (Exception e) {
				System.out.println("Error during registration of exercise into group. Try again!" + e.toString());
			}
			break;
		case GET_EXCERSICE_IN_GROUP:
				
			break;
		default:
			break;
		}
	}
	
	public void printMenu() {
		System.out.println("Velg mellom disse alternativene! (Choose between the following alternatives:)"
				+ "\n 1. Register an excercise"
				+ "\n 2. Register a workout"
				+ "\n 3. Register something");
	}
	
	public static void main(String[] args) {
		
		DatabaseConnectivity.openConnection();
		
		MainController sessionController = new MainController();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Hei og velkomment til en fantastisk treningsdagbok!");
		System.out.println("Velg mellom disse alternativene! (Choose between the following alternatives:)"
				+ "\n 1. Register an excercise"
				+ "\n 2. Register a workout"
				+ "\n 3. Register an equipment"
				+ "\n 4. Register an exercise group"
				+ "\n 5. Add exercise to exercise group"
				+ "\n 6. Show all exercises in the database"
				+ "\n 7. Show all workouts in the database"
				+ "\n 8. Show all eqipment in the database"
				+ "\n 9. Show all exercise groups in the database"
				+ "\n 10. Show all exercises in a group"				
				+ "\n 11. See the n last workouts with notes"
				+ "\n 12. See the results of one exercise in a given time interval"
				+ "\n 13. See the most frequent exercise");
		
		while(true) {
	        String userString = null;
			try {
				userString = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sessionController.takeInput(userString);
		}
		
	}

}
