package mru.game.view;

import java.util.Scanner;

import mru.game.model.Player;


/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 */
public class AppMenu {
	
	Scanner input;
	/**
	 * constracter for the app menu
	 */
	public AppMenu() {
		input = new Scanner(System.in);
		
	}
	
	/**
	 * the main menu contains options
	 * @return choice allow you to select an option
	 */
	public char mainMenu() {
		System.out.print("\nSelect one of these options: \n"
				+ "\n"
				+ "       (P) Play game\n"
				+ "       (S) Search\n"
				+ "       (E) Exit\n"
				+ "\n"
				+ "Enter a choice: ");
		char choice = input.next().toLowerCase().charAt(0);
		return choice;
	}
	/**
	 * the sub menu contains options
	 * @return choice allow you to select an option
	 */
	public char subMenu() {
		System.out.print("\nSelect one of these options;\n"
				+ "\n        (T) Top player (Most number of wins)"
				+ "\n        (N) Looking for a name"
				+ "\n        (B) Back to Main menu"
				+ "\n\nEnter a choice: ");
		char choice = input.next().toLowerCase().charAt(0);
		return choice;
	}
	
	/**
	 * askes users for their name
	 * @return name the inputed player name
	 */
	public String enterName() {
		System.out.println("Enter name here: ");
		String name = input.next();
		return name;
	}
	
	/**
	 *displayes the desired player info menu
	 * @param
	 */
	public void plyInfo(Player ply)
	{
		if(ply != null)
		{
		System.out.print(ply);
		}else {
			System.out.print("the name u entered does not exist");

		}
	}
	public void topPlayerMenu()
	{
		System.out.printf("%n      -PLAYER INFO-          "
				+ "%n+=================+=================+"
				+ "%n|NAME             |# WINS           |"
				+ "%n+=================+=================+");
	}
	
	
	
}

