import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hello! Welcome to the program.");
		
		
		String response = "";
		boolean quit = false; //Set up a loop until the user selects quit
		while (!quit)
		{
			System.out.println("Please select an option: Battle Mode or Quit");
			response = input.nextLine();
			if (response.equalsIgnoreCase("Battle Mode"))	{	
				Battle.battleMode();
			}
			else if (response.equalsIgnoreCase("Quit"))	{
				quit = true;
				System.out.println("Now quitting");
			}
			else	{
				System.out.println("Invalid response");
			}
			
		}
		
	}
}
