package rock_paper_scissors;

import java.util.Scanner;
import java.util.Random;

public class MainApp {

	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		Random random = new Random();
		char[] choices = {'s', 'r', 'p', 'S', 'R', 'P'};
		char random_choice = choices[random.nextInt(choices.length)];
		
		int scorePlayer = 0;
		int scorePc = 0;
		
		while (scorePlayer != 3 && scorePc !=3) {
			 switch (gameRound(playerChoice(), random_choice)) {
			    case 1:
			    	scorePlayer ++;
			    	break;
			    case 2:
			    	scorePc ++;
			    	break;
			    default:
			    	break;
			 }
			System.out.println("Player Score : "+scorePlayer+
					 " | Pc score : "+scorePc);	
		}
		input.close();

	}
	
	public static char playerChoice() {
		Scanner input = new Scanner (System.in);
		char choice ;
		String valid_choices = "RSPrsp";
		do {
			System.out.println("R for rock");
			System.out.println("S for scissors");
			System.out.println("P for paper");
			System.out.print("Make a choice : ");
			choice = input.next().charAt(0);			
		}while(valid_choices.indexOf(choice) == -1);
		return  choice;
	}
	
	public static String playersSelection(char choice) {
		String object = null;
		switch (choice) {
			case 'R':
			case 'r':
				object = "Rock";
				break;
			case 'S':
			case 's':	
				object = "Scissors";
				break;
			case 'P':
			case 'p':
				object = "Paper";
				break;
		}
		return object;
	}
	
	public static int gameRound(char playerChoice, char choicePc){
		int result = 0 ;
		System.out.println("Your choice is : "+playersSelection(playerChoice)+" | The PC's choice is : "+playersSelection(choicePc));
		if (playerChoice == 'p' && choicePc == 'r' || playerChoice == 'P' && choicePc == 'R' || playerChoice == 's' && choicePc == 'p' || playerChoice == 'S' && choicePc == 'P' || playerChoice == 'r' && choicePc == 's' || playerChoice == 'R' && choicePc == 'S') {
			System.out.println("You win this one you lucky son of a bitch");
			result = 1; 
		} else if (playerChoice == choicePc) {
			System.out.println("It's a draw, tight game bitch");
			result = 0;
		} else {
			System.out.println("You lost this round bitch ! The Pc beat your ass");
			result = 2;
		}
		return result;
	}
	
	
}
