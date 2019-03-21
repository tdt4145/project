package Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import classes.*;

//En klasse som inneholder all logikk rundt brukeropplevelsen
public class MainController {
	public ControllerState controllerState;
	public Workout newWorkout;
	public ArrayList<Exercise> exerciseArray;
	public Exercise newExercise = new Exercise("name", "desc");
	
	
	public MainController() {
		this.controllerState = ControllerState.INIT;
		this.newWorkout = new Workout("name", "desc", "date", "time", "dur", 5);
		this.exerciseArray = new ArrayList<Exercise>();
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
				System.out.println("Please input the exercise data in the following format \"name, description, equipment ID\", if an equpment is not needed set the last parameter to NULL)");
				this.controllerState = ControllerState.INSERT_EXERCISE;
				return;
			case "2":
				System.out.println("Please input the Workout data in the following format (date, time)");
				this.controllerState = ControllerState.INSERT_EXERCISE_INTO_WORKOUT;
				return;
			case "3":
				System.out.println("Please input the equipment data in the following format (date, desc)");
				this.controllerState = ControllerState.INSERT_EQUIPMENT;
				return;
			case "4":
				System.out.println("Please input the group data in the following format (date, desc)");
				this.controllerState = ControllerState.INSERT_EXERCISE_GROUP;
				return;
			case "5":
				Handler.showAllExercises();
				return;
			case "6":
				Handler.showAllWorkouts();
				return;
			case "7":
				Handler.showAllEquipment();
				return;
			case "8":
				Handler.showAllGroups();
				return;
			case "9":
				System.out.println("Please input the group for which you whish to se the exercises:");
				this.controllerState = ControllerState.INSERT_GROUP_NUMBER_FOR_VIEWING_EXERCISES;
				return;
			case "10":
				System.out.println("Please input the amount of the last completed workouts you whish to see:");
				this.controllerState = ControllerState.INSERT_NUMBER_FOR_VIEWING_LATEST_WORKOUTS;
				return;
			case "11":
				//TODO: Discuss with Petter the desired input format
				System.out.println("Please input the the exercise ID and the time interval in the following format: \"ID\",\"DD.MM.YYYY\",\\\"DD.MM.YYYY\\\"");
				this.controllerState = ControllerState.INSERT_NUMBER_FOR_VIEWING_LATEST_WORKOUTS;
				return;
			case "12":
				Handler.showMostFrequentExercise();
				return;
			default:
				break;
			}
			break;
		case INSERT_EXERCISE:
			// Will take infor that is relevant for both sublclasses of the exercise class. Will then dfference depending on the input
			// 
			
			// Will treat the user input as a touple that describes an exercise
			userStringSplit = userString.split(", ");
			this.newExercise = new Exercise(userStringSplit[0], userStringSplit[1]);
			if(userStringSplit[5] == "true") {
				this.controllerState = ControllerState.INSERT_EXERCISE_WITH_EQUIPMENT;
			}
			
			
			
		case CREATE_WORKOUT:
			// Vil her be brukeren om å skrive inn en gyldig tuppel for å lage et workout-objekt
			try {
				userStringSplit = userString.split(", ");
				Workout newWorkOut = new Workout(userString, userString, userString, userString, userString, 0);
				this.newWorkout = new Workout(userStringSplit[0], userStringSplit[1], userStringSplit[2], userStringSplit[3], userStringSplit[4], Integer.parseInt(userStringSplit[5]));
				this.exerciseArray.clear();
				System.out.println("Registrated the Workout successfully, please insert the exercise data on the desired format. Write \"done\" when done.");
				this.controllerState = ControllerState.INSERT_EXERCISE_INTO_WORKOUT;
			} catch (Exception e) {
				System.out.println("Error during registration. Try again!");
			}
			
			break;
		case INSERT_EXERCISE_INTO_WORKOUT:
			if(userString == "done") {
				//Trigger method in Handler to save the Workout object with the list of Exercises
			}
			// Will treat the inout as a new exercise that will be added to the List
			
			
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
				+ "\n 5. Show all exercises in the database"
				+ "\n 6. Show all workouts in the database"
				+ "\n 7. Show all eqipment in the database"
				+ "\n 8. Show all exercise groups in the database"
				+ "\n 9. Show all exercises in a group"				
				+ "\n 10. See the n last workouts with notes"
				+ "\n 11. See the results of one exercise in a given time interval"
				+ "\n 12. See the most frequent exercise");
		
		
		
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
