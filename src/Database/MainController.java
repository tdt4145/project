package Database;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//En klasse som inneholder all logikk rundt brukeropplevelsen
public class MainController {
	
	
	public MainController() {
	}
	
	public void takeInput(String userString) {
		
	}
	
	
	public static void main(String[] args) {
		MainController sessionController = new MainController();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.print("Enter String");
	        String userString = reader.readLine();
			sessionController.takeInput(userString);
		}
		
        
		
		
        System.out.print("Enter Integer:");
        try{
            int i = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
		
	}

}
