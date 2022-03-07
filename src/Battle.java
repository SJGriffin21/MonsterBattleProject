import java.util.Scanner;
import java.io.*;

public class Battle {
	
	public static void battleMode()
	{
		Scanner userFile = new Scanner(System.in); //Set up scanner and variable for files
		String fileName = "";
		System.out.println("Please enter a file to make monster 1.");
		
		String tempName = "";
		double tempHealth = 0.0; 		// Set up the temporary variables to put into monster
		double tempStrength = 0.0;
		
		Scanner readFile = null;
		boolean success = false;
		File file1 = null;
		while (!success) {
			fileName = userFile.nextLine();
			file1 = new File(fileName);
			try {
				readFile = new Scanner(file1);   	// loop to read first file
				success = true;
			} catch (FileNotFoundException e) {			 
				System.out.println("That file does not exist, please try again");
			}
		}
		tempName = readFile.nextLine();
		tempHealth = readFile.nextDouble();
		tempStrength = readFile.nextDouble();
		
		Monster monster1 = new Monster(tempName, tempHealth, tempStrength);  // set up first monster
		
		success = false; 		//reset loop condition
		
		System.out.println("Please enter a file to make monster 2.");
		
		File file2 = null;
		while (!success) {
			fileName = userFile.nextLine();
			file2 = new File(fileName);
			try {
				readFile = new Scanner(file2);
				success = true;
			} catch (FileNotFoundException e) {				// loop to read second file
				System.out.println("That file does not exist, please try again");
			}
		}
		tempName = readFile.nextLine();
		tempHealth = readFile.nextDouble();
		tempStrength = readFile.nextDouble();
		
		Monster monster2 = new Monster(tempName, tempHealth, tempStrength);  // set up monster 2
		
		int roundCounter = 1;
		boolean battleOver = false; 	// set up variables for the battle
		double monster1Attack = 0.0;
		double monster2Attack = 0.0;
		
		while (!battleOver) {
			System.out.println("Round " + roundCounter);
			
			monster1Attack = monster1.attack();
			monster2.takeDamage(monster1Attack);		//Monster1's attack
			System.out.println(monster1.getName() + " attacked " + monster2.getName() + " for " + String.format("%.2f", monster1Attack) + " damage!");
			
			monster2Attack = monster2.attack();
			monster1.takeDamage(monster2Attack);		//Monster2's attack
			System.out.println(monster2.getName() + " attacked " + monster1.getName() + " for " + String.format("%.2f", monster2Attack) + " damage!");
			
			System.out.println(monster1.toString());	//print monster info
			System.out.println(monster2.toString());
			
			if(!(monster1.isAlive() && monster2.isAlive())) {
				battleOver = true;				//check if either of the monsters died and end the loop if they died
			}	
			roundCounter += 1;
			System.out.println();
		}
		
		
		
		if (!(monster1.isAlive() || monster2.isAlive())) {			//see which monster won or if they tied
			System.out.println("The battle was a tie!");
		}
		else if (monster1.isAlive()) {
			System.out.println(monster1.getName() + " won!");
		}
		else if (monster2.isAlive()) {
			System.out.println(monster2.getName() + " won!");	
		}
		
	}
}
