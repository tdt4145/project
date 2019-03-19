package Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//En klasse som inneholder all logikk rundt brukeropplevelsen
public class MainController {
	public ControllerState controllerState;
	
	
	public MainController() {
		this.controllerState = ControllerState.INIT;
	}
	
	//Takes input and responds to the user and changes the state accordingly 
	public void takeInput(String userString) {
		if(userString == null) {
			return;
		}
		if(userString == "dev") {
			System.out.println("State: " + this.controllerState + " ");
		}
		
		switch (this.controllerState) {
		case INIT:
			switch (userString) {
			case "1":
				System.out.println("Please input the excercise data in the following format (date, desc)");
				this.controllerState = ControllerState.INSERT_EXERCISE;
				return;
			case "2":
				System.out.println("Please input the equipment data in the following format (date, desc)");
				this.controllerState = ControllerState.INSERT_EQUIPMENT;
				return;
			case "3":
				System.out.println("Please input the excercise groupt data in the following format (date, desc)");
				this.controllerState = ControllerState.INSERT_EXERCISE_GROUP;
				return;
			default:
				break;
			}
			break;
		case INSERT_EXERCISE:
			if(!Handler.registerExercise(userString)) {
				System.out.println("The data is not in the desired format. Please try again:");
				break;
			}else {
				System.out.println("The data is successfully resgistered in the database!");
				this.controllerState = ControllerState.INIT;
				printMenu();
			}
		case INSERT_WORKOUT:
			if(!Handler.registerWorkout(userString)) {
				System.out.println("The data is not in the desired format. Please try again:");
				break;
			}else {
				System.out.println("The data is successfully resgistered in the database!");
				this.controllerState = ControllerState.INIT;
				printMenu();
			}
			break;
		case GET_EXCERSICE_IN_GROUP:
			if(!Handler.getExerciseInGooup(userString)) {
				System.out.println("The data is not in the desired format. Please try again:");
				break;
			}else {
				System.out.println("The data is successfully resgistered in the database!");
				this.controllerState = ControllerState.INIT;
				printMenu();
				
			}
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
		
		MainController sessionController = new MainController();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Hei og velkomment til en fantastisk treningsdagbok!");
		System.out.println("Velg mellom disse alternativene! (Choose between the following alternatives:)"
				+ "\n 1. Register an excercise"
				+ "\n 2. Register a workout"
				+ "\n 3. Register something"
				+ "\n 4. See the n last workouts");
		
		
		
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
