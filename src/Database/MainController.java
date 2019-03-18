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
	
	public void takeInput(String userString) {
		if(userString == null) {
			return;
		}
		
		switch (this.controllerState) {
		case INIT:
			switch (userString) {
			case "1":
				System.out.println("Når er det bare å kjøre inn data om øvelsen!");
				this.controllerState = ControllerState.INSERT_EXERCISE;
				return;
			case "2":
				System.out.println("Når er det bare å kjøre inn data om apparatet!");
				this.controllerState = ControllerState.INSERT_EQUIPMENT;
				return;
			case "3":
				System.out.println("Når er det bare å kjøre inn data om aktivitetsgruppen!");
				this.controllerState = ControllerState.INSERT_EQUIPMENT;
				return;
			default:
				break;
			}
			break;
		case INSERT_EXERCISE:
			System.out.println(Exercise.registerExercise(userString));
			if(good) {
				this.controllerState = controllerState.INIT;
			}
			break;
		case INSERT_WORKOUT:
			System.out.println(registerWorkout(userString));
			break;
		case GET_EXCERSICE_IN_GROUP:
			System.out.println(getExerciseInGroup(groupString)(userString));
			break;

		default:
			break;
		}
		
	}
	
	public String registerExercise(String exerciseString) {
		//Try to create exersice in database, print eventuell feilmelding
		return "Haha funker dritbra! Aktiviteten er inne i databasen!";
	}
	
	public 
	
	public String getExerciseInGroup(String groupString) {
		
		//Try to create exersice in database, print eventuell feilmelding
		return "Haha funker dritbra! Aktiviteten er inne i databasen!";
	}
	
	public static void main(String[] args) {
		MainController sessionController = new MainController();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Hei og velkomment til en fantastisk treningsdagbok!");
		System.out.println("Velg mellom disse alternativene! (Choose between the following alternatives:)"
				+ "\n 1. Register an excercise"
				+ "\n 2. Register a workout"
				+ "\n 3. Register something");
		
		
		
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
